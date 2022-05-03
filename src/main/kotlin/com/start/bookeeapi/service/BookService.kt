package com.start.bookeeapi.service

import com.start.bookeeapi.dbos.Author
import com.start.bookeeapi.dbos.Book
import com.start.bookeeapi.repositories.AuthorRepository
import com.start.bookeeapi.repositories.BookRepository
import com.start.bookeeapi.repositories.PublisherRepository
import com.start.bookeeapi.util.Genres
import com.start.bookeeapi.util.getGenreByString
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(
    val bookRepository: BookRepository,
    val authorRepository: AuthorRepository,
    val publisherRepository: PublisherRepository
) {

    fun getAllBooks(maxResult: Int, page: Int): List<Book> {
        return bookRepository.findAll(PageRequest.of(page, maxResult)).toList()
    }

    fun getById(id: UUID): Book {
        return bookRepository.getById(id)
    }

    fun createBook(body: Book): Book {
        val enumList = Genres.values().toList()
        val matchedGenres = body.genres.split(",").joinToString(",") { genre -> enumList.getGenreByString(genre) }
        return bookRepository.save(
            body.copy(
                genres = matchedGenres,
                authors = findAuthorsToPersistAndMerge(body.authors),
                publisher = publisherRepository.findPublisherByNameAndCountry(
                    body.publisher.name,
                    body.publisher.country
                ) ?: body.publisher
            )
        )
    }

    /**
     * This function helps in finding the already existing authors and merging them with the authors specified in the request.
     * The result will then contain new authors which need to be added to the database and authors
     * which already exist (the existing will not be created again and only a reference to the author will be saved)
     */
    private fun findAuthorsToPersistAndMerge(authors: Set<Author>): Set<Author> {
        val authorsExists = authors.mapNotNull { author ->
            authorRepository.findAuthorByFirstNameAndLastName(
                author.firstName,
                author.lastName
            )
        }
        return authors.filterNot { bodyAuthor -> authorsExists.any { existingAuthor -> existingAuthor.firstName == bodyAuthor.firstName && existingAuthor.lastName == bodyAuthor.lastName } }
            .toSet()
    }
}
package com.start.bookeeapi.service

import com.start.bookeeapi.dbos.Author
import com.start.bookeeapi.dbos.Book
import com.start.bookeeapi.repositories.AuthorRepository
import com.start.bookeeapi.repositories.BookRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorService(
    val authorRepository: AuthorRepository,
    val bookRepository: BookRepository
) {
    fun getAllBooksByAuthor(id: UUID): List<Book> {
        return bookRepository.findAllByAuthorsId(id)
    }

    fun getAuthorsByName(name: String): List<Author> {
        return authorRepository.findAllByFirstNameOrLastNameContains(name)
    }
}
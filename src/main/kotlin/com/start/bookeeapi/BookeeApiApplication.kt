package com.start.bookeeapi

import com.start.bookeeapi.dbos.Author
import com.start.bookeeapi.dbos.Book
import com.start.bookeeapi.dbos.Publisher
import com.start.bookeeapi.repositories.BookRepository
import com.start.bookeeapi.util.Genres
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service

@SpringBootApplication
class BookeeApiApplication

fun main(args: Array<String>) {
	runApplication<BookeeApiApplication>(*args)
}

@Service
class Start(
	val bookRepository: BookRepository
) {
/*	@PostConstruct
	@Order(0)
	@Transactional*/
	fun setup() {
		bookRepository.save(Book(
			title = "Harry Potter and the Sorcerer's Stone",
			summary = "TESTSUM",
			isbn = "123",
			publisher = Publisher(name = "Vegas", country = "USA"),
			genres = setOf(Genres.ACTION, Genres.DYSTOPIAN).joinToString(separator = ","),
			language = "english",
			pageCount = 449,
			authors = setOf(Author(firstName = "Graciel Angelica", lastName = "Obena")),
			translations = setOf(
				Book(
					title = "Harry Potter und der Stein der Weisen",
					summary = "TESTSUM-GERMAN",
					isbn = "123342543",
					publisher = Publisher(name = "LB", country = "Germany"),
					genres = setOf(Genres.ACTION, Genres.DYSTOPIAN).joinToString(separator = ","),
					language = "german",
					pageCount = 449,
					authors = setOf(Author(firstName = "Irman", lastName = "Omerovic"))
				)
			)
		))
		bookRepository.save(
			Book(
				title = "1984",
				summary = "TESTSUM",
				isbn = "123455",
				publisher = Publisher(name = "STUTTGART2", country = "Germany"),
				genres = setOf(Genres.GRAPHIC_NOVEL, Genres.SCI_FI).joinToString(separator = ","),
				language = "german",
				pageCount = 449,
				authors = setOf(Author(firstName = "Irman", lastName = "Omerovic"))
			)
		)
		val foundBook = bookRepository.findAll()
		println(foundBook[0].publisher)
	}
}

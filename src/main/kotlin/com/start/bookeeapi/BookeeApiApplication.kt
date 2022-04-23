package com.start.bookeeapi

import com.start.bookeeapi.dbos.Book
import com.start.bookeeapi.dbos.Publisher
import com.start.bookeeapi.repositories.BookRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import javax.transaction.Transactional

@SpringBootApplication
class BookeeApiApplication

fun main(args: Array<String>) {
	runApplication<BookeeApiApplication>(*args)
}

@Service
class Start(
	val bookRepository: BookRepository
) {
	@PostConstruct
	@Order(0)
	@Transactional
	fun setup() {
		bookRepository.save(Book(
			title = "TEST",
			summary = "TESTSUM",
			isbn = "123",
			publishers = setOf(Publisher(name = "LB"))
		))
		bookRepository.save(Book(
			title = "TEST",
			summary = "TESTSUM",
			isbn = "123455",
			publishers = setOf(Publisher(name = "STUTTGART"), Publisher(name = "STUTTGART2"))
		))
/*		val foundBook = bookRepository.findAll()
		println(foundBook[0].publishers)*/
	}

	@PostConstruct
	@Order(1)
	fun fetch() {
		val books = bookRepository.findAllWithPublishers()
		println(books)
	}
}

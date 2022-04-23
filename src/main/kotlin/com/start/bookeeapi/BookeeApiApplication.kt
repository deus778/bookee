package com.start.bookeeapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookeeApiApplication

fun main(args: Array<String>) {
	runApplication<BookeeApiApplication>(*args)
}

package com.start.bookeeapi.controller

import com.start.bookeeapi.dbos.Book
import com.start.bookeeapi.service.BookService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(path = ["books"])
class BookController(
    val bookService: BookService
) {

    @GetMapping
    fun getAllBooks(@RequestParam maxResult: Int = 100, @RequestParam page: Int = 0): List<Book> {
        return bookService.getAllBooks(maxResult, page)
    }

    @GetMapping(path = ["/{id}/book"])
    fun getBook(@PathVariable id: UUID): Book {
        return bookService.getById(id)
    }
}
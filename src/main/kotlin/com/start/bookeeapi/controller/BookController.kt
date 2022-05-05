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
    fun getAllBooks(@RequestParam maxResult: Int?, @RequestParam page: Int?): List<Book> {
        return bookService.getAllBooks(maxResult ?: 100, page ?: 0)
    }

    @GetMapping(path = ["/{id}/book"])
    fun getBook(@PathVariable id: UUID): Book {
        return bookService.getById(id)
    }

    @PostMapping(path = ["/create"])
    fun createBook(@RequestBody body: Book): Book {
        return bookService.createBook(body)
    }

    @DeleteMapping(path = ["/{id}/delete"])
    fun deleteBook(@PathVariable id: UUID): Book {
        return bookService.deleteBook(id)
    }
}
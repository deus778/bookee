package com.start.bookeeapi.controller

import com.start.bookeeapi.dbos.Author
import com.start.bookeeapi.dbos.Book
import com.start.bookeeapi.service.AuthorService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(path = ["authors"])
class AuthorController(
    val authorService: AuthorService
) {

    @GetMapping(path = ["/{id}/books"])
    fun getAllBooksByAuthor(@PathVariable id: UUID): List<Book> {
        return authorService.getAllBooksByAuthor(id)
    }

    @GetMapping
    fun getAuthorsByName(@RequestParam(required = false) name: String): List<Author> {
        return authorService.getAuthorsByName(name)
    }
}
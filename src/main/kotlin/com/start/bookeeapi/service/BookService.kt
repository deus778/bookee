package com.start.bookeeapi.service

import com.start.bookeeapi.dbos.Book
import com.start.bookeeapi.repositories.BookRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun getAllBooks(maxResult: Int, page: Int): List<Book> {
        return bookRepository.findAll(PageRequest.of(page, maxResult)).toList()
    }

    fun getById(id: UUID): Book {
        return bookRepository.getById(id)
    }
}
package com.start.bookeeapi.repositories

import com.start.bookeeapi.dbos.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookRepository : JpaRepository<Book, UUID> {

    fun findByTitleContains(matchTitle: String): List<Book>

    fun findAllByAuthorsId(id: UUID): List<Book>
}
package com.start.bookeeapi.repositories

import com.start.bookeeapi.dbos.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookRepository : JpaRepository<Book, UUID> {

    @Query("SELECT b from Book b join fetch b.publishers")
    fun findAllWithPublishers() : Set<Book>
}
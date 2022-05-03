package com.start.bookeeapi.repositories

import com.start.bookeeapi.dbos.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AuthorRepository : JpaRepository<Author, UUID> {

    fun findAuthorByFirstNameAndLastName(firstName: String, lastName: String): Author?

    @Query("SELECT a FROM Author a where a.firstName LIKE %:name% OR a.lastName LIKE %:name%")
    fun findAllByFirstNameOrLastNameContains(name: String): List<Author>
}
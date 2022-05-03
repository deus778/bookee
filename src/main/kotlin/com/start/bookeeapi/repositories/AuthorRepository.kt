package com.start.bookeeapi.repositories

import com.start.bookeeapi.dbos.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AuthorRepository : JpaRepository<Author, UUID> {

    fun findAuthorByFirstNameAndLastName(firstName: String, lastName: String): Author?
}
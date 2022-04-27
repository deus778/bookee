package com.start.bookeeapi.repositories

import com.start.bookeeapi.dbos.Author
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AuthorRepository : JpaRepository<Author, UUID> {

}
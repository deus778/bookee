package com.start.bookeeapi.dbos

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "authors")
data class Author(
    @Id
    val id: UUID = UUID.randomUUID(),
    val firstName: String,
    val lastName: String,
)

package com.start.bookeeapi.dbos

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "publishers")
data class Publisher(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(name = "name")
    val name: String,
    val country: String
)

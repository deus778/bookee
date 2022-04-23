package com.start.bookeeapi.dbos

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "publishers")
data class Publisher(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(name = "name")
    val name: String
)

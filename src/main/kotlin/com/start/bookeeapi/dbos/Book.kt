package com.start.bookeeapi.dbos

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(name = "title")
    val title: String,
    @Column(name = "summary")
    val summary: String,
    @Column(name = "isbn", unique = true)
    val isbn: String,
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_publishers",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "publisher_id")]
    )
    val publishers: Set<Publisher>,
)

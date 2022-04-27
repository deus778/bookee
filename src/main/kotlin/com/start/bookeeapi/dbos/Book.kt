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
    val isbn: String, // ISBN's have the length of 10, if assigned before 2007, and a length of 13, if assigned after 1. January 2007
    @Column(name = "genres")
    val genres: String,
    @Column(name = "language")
    val language: String,
    @Column(name = "pages")
    val pageCount: Int,
    @OneToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE], fetch = FetchType.EAGER)
    val publisher: Publisher,
    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE], fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_authors",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val authors: Set<Author>,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    val translations: Set<Book>? = null,
    // TODO add link to thumbnails or images - DOMAIN + UUID + _COUNT
)

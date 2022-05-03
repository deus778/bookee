package com.start.bookeeapi.repositories

import com.start.bookeeapi.dbos.Publisher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PublisherRepository : JpaRepository<Publisher, UUID> {

    fun findPublisherByNameAndCountry(name: String, country: String): Publisher?
}
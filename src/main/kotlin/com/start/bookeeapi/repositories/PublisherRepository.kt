package com.start.bookeeapi.repositories

import com.start.bookeeapi.dbos.Publisher
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PublisherRepository : JpaRepository<Publisher, UUID> {
}
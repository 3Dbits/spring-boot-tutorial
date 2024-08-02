package com.ht.springboottutorial.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Documentation(
    @Id
    val id: String? = null,
    val dateCreated: LocalDateTime,
    val data: String
)
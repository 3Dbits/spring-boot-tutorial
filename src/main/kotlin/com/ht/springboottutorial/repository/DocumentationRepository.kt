package com.ht.springboottutorial.repository

import com.ht.springboottutorial.models.Documentation
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface DocumentationRepository : ReactiveMongoRepository<Documentation, String>
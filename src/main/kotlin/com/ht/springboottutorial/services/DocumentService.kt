package com.ht.springboottutorial.services

import com.ht.springboottutorial.models.Documentation
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DocumentationService {
    fun getDocumentation(): Flux<Documentation>
    fun saveDocument(data: String): Mono<Documentation>
    fun updateDocument(id: String, data: String): Mono<Documentation>
    fun deleteDocument(id: String): Mono<Void>
}
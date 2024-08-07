package com.ht.springboottutorial.controllers

import com.ht.springboottutorial.models.Documentation
import com.ht.springboottutorial.models.DocumentationPostDto
import com.ht.springboottutorial.services.DocumentationService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/documentation")
class DocumentationController(
    private val documentationService: DocumentationService
) {

    @GetMapping
    fun getAllDocuments(): Flux<Documentation> =
        documentationService.getDocumentation()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createDocument(@RequestBody request: DocumentationPostDto) =
        documentationService.saveDocument(request.data)

    @PutMapping("/{id}")
    fun updateDocument(@PathVariable id: String, @RequestBody data: String): Mono<Documentation> =
        documentationService.updateDocument(id, data)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteDocument(@PathVariable id: String): Mono<Void> =
        documentationService.deleteDocument(id)
}
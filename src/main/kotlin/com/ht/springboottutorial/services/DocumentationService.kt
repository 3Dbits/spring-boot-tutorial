package com.ht.springboottutorial.services

import com.ht.springboottutorial.models.Documentation
import com.ht.springboottutorial.repository.DocumentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class DocumentationService(private val documentationRepository : DocumentationRepository) {
    fun getDocumentation() = documentationRepository.findAll()

    fun saveDocument(data: String) =
        documentationRepository.save(
            Documentation(id = null, LocalDateTime.now(), data = data))

    fun updateDocument(id: String, data: String) =
        documentationRepository.findById(id)
            .flatMap { existingDocument ->
                val updatedDocument = existingDocument.copy(data = data)
                documentationRepository.save(updatedDocument)
            }

    fun deleteDocument(id: String) = documentationRepository.deleteById(id)
}
package com.ht.springboottutorial.services

import com.ht.springboottutorial.models.Documentation
import com.ht.springboottutorial.repository.DocumentationRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DocumentationServiceImpl(private val documentationRepository : DocumentationRepository) :
    DocumentationService {
    override fun getDocumentation() = documentationRepository.findAll()

    override fun saveDocument(data: String) =
        documentationRepository.save(
            Documentation(id = null, LocalDateTime.now(), data = data))

    override fun updateDocument(id: String, data: String) =
        documentationRepository.findById(id)
            .flatMap { existingDocument ->
                val updatedDocument = existingDocument.copy(data = data)
                documentationRepository.save(updatedDocument)
            }

    override fun deleteDocument(id: String) = documentationRepository.deleteById(id)
}
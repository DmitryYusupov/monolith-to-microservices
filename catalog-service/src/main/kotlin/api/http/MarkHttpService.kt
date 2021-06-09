package ru.yusdm.monolithtomicro.catalog.api.http

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.catalog.domain.toDTO
import ru.yusdm.monolithtomicro.catalog.dto.CreateMarkCommandDTO
import ru.yusdm.monolithtomicro.catalog.dto.MarkDTO
import ru.yusdm.monolithtomicro.catalog.dto.toCreateMarkCommandModel
import ru.yusdm.monolithtomicro.catalog.service.MarkService
import java.util.*

@Service
class MarkHttpService(private val markService: MarkService) {

    fun save(createMarkCommand: CreateMarkCommandDTO): ResponseEntity<MarkDTO> {
        return ResponseEntity.ok(
            markService.create(createMarkCommand.toCreateMarkCommandModel()).toDTO()
        )
    }

    fun finaAll(): ResponseEntity<List<MarkDTO>> {
        return ResponseEntity.ok(
            markService.findAll().map { it.toDTO() }
        )
    }

    fun addModelToMark(markId: UUID, modelName: String) {
        markService.addModelToMark(markId, modelName)
    }
}
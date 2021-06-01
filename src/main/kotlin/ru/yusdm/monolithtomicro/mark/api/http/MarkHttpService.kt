package ru.yusdm.monolithtomicro.mark.api.http

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.mark.domain.toDTO
import ru.yusdm.monolithtomicro.mark.dto.CreateMarkCommandDTO
import ru.yusdm.monolithtomicro.mark.dto.MarkDTO
import ru.yusdm.monolithtomicro.mark.dto.toCreateMarkCommandModel
import ru.yusdm.monolithtomicro.mark.service.MarkService

@Service
class MarkHttpService(private val markService: MarkService) {

    fun save(createMarkCommand: CreateMarkCommandDTO): ResponseEntity<MarkDTO> {
        return ResponseEntity.ok(
            markService.createMark(createMarkCommand.toCreateMarkCommandModel()).toDTO()
        )
    }

    fun finaAll(): ResponseEntity<List<MarkDTO>> {
        return ResponseEntity.ok(
            markService.findAll().map { it.toDTO() }
        )
    }
}
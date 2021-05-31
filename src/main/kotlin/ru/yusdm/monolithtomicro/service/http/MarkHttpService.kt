package ru.yusdm.monolithtomicro.service.http

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.domain.toDTO
import ru.yusdm.monolithtomicro.dto.CreateMarkCommandDTO
import ru.yusdm.monolithtomicro.dto.MarkDTO
import ru.yusdm.monolithtomicro.dto.toCreateMarkCommandModel
import ru.yusdm.monolithtomicro.service.MarkService

@Service
class MarkHttpService(private val markService: MarkService) {

    fun save(createMarkCommand: CreateMarkCommandDTO): MarkDTO {
        return markService.createMark(createMarkCommand.toCreateMarkCommandModel()).toDTO()
    }
}
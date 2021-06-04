package ru.yusdm.monolithtomicro.mark.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.mark.domain.Mark
import ru.yusdm.monolithtomicro.mark.service.edit.CreateMarkCommand
import ru.yusdm.monolithtomicro.mark.service.edit.MarkEditService
import ru.yusdm.monolithtomicro.mark.service.search.MarkSearchService
import java.util.*

@Service
@Transactional
class MarkService(
    private val markEditService: MarkEditService,
    private val markSearchService: MarkSearchService
) {
    fun createMark(createMarkCommand: CreateMarkCommand): Mark = markEditService.createMark(createMarkCommand)

    fun addModelToMark(markId: UUID, modelName: String) = markEditService.addModelToMark(markId, modelName)

    fun findAll(): List<Mark> = markSearchService.findAll()
}


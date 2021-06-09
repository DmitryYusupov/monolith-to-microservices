package ru.yusdm.monolithtomicro.catalog.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.catalog.domain.Mark
import ru.yusdm.monolithtomicro.catalog.service.edit.CreateMarkCommand
import ru.yusdm.monolithtomicro.catalog.service.edit.MarkEditService
import ru.yusdm.monolithtomicro.catalog.service.search.MarkSearchService
import java.util.*

@Service
@Transactional
class MarkService(
    private val markEditService: MarkEditService,
    private val markSearchService: MarkSearchService
) {
    fun create(createMarkCommand: CreateMarkCommand): Mark = markEditService.create(createMarkCommand)

    fun addModelToMark(markId: UUID, modelName: String): Unit = markEditService.addModelToMark(markId, modelName)

    fun findAll(): List<Mark> = markSearchService.findAll()
}


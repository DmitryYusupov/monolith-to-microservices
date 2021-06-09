package ru.yusdm.monolithtomicro.mark.service.edit

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.mark.domain.Mark
import ru.yusdm.monolithtomicro.mark.domain.Model
import ru.yusdm.monolithtomicro.mark.domain.toEntity
import ru.yusdm.monolithtomicro.mark.repository.MarkRepository
import ru.yusdm.monolithtomicro.model.connector.ModelApiService
import java.util.*

@Service
@Transactional
class MarkEditService(
    private val markRepository: MarkRepository,
    private val modelApiService: ModelApiService
) {

    fun create(createMarkCommand: CreateMarkCommand): Mark {

        return with(createMarkCommand) {
            val mark = Mark(name = this.name)
            mark.models = this.models?.map { Model(name = it.name) } ?: emptyList()

            val savedMark = markRepository.save(mark.toEntity())
            this.models?.forEach {
                addModelToMark(savedMark.id, it.name)
            }

            mark
        }
    }

    fun addModelToMark(markId: UUID, modelName: String) {
        modelApiService.save(ru.yusdm.monolithtomicro.model.connector.Model(name = modelName, markId = markId))
    }

}
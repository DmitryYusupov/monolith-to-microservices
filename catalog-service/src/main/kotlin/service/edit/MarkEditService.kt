package ru.yusdm.monolithtomicro.catalog.service.edit

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.catalog.domain.Mark
import ru.yusdm.monolithtomicro.catalog.domain.Model
import ru.yusdm.monolithtomicro.catalog.domain.toEntity
import ru.yusdm.monolithtomicro.catalog.repository.MarkRepository
import ru.yusdm.monolithtomicro.catalog.repository.ModelRepository
import java.util.*

@Service
@Transactional
class MarkEditService(
    private val markRepository: MarkRepository,
    private val modelRepository: ModelRepository
) {

    fun create(createMarkCommand: CreateMarkCommand): Mark {

        return with(createMarkCommand) {
            val mark = Mark(name = this.name)
            mark.models = models?.let {
                it.map { Model(name = it.name, mark = mark) }
            }
            markRepository.save(mark.toEntity())

            mark
        }
    }

    fun addModelToMark(markId: UUID, modelName: String) {
        modelRepository.toString()
        //your logic here
    }

}
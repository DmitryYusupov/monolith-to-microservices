package ru.yusdm.monolithtomicro.mark.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.mark.domain.Mark
import ru.yusdm.monolithtomicro.mark.domain.toEntity
import ru.yusdm.monolithtomicro.mark.repository.MarkRepository
import ru.yusdm.monolithtomicro.model.domain.Model
import ru.yusdm.monolithtomicro.model.repository.ModelRepository

@Service
@Transactional
class MarkService(
    private val markRepository: MarkRepository,
    private val modelRepository: ModelRepository
) {

    fun createMark(createMarkCommand: CreateMarkCommand): Mark {

        return with(createMarkCommand) {
            val mark = Mark(name = this.name)
            mark.models = models?.let {
                it.map { Model(name = it.name, mark = mark) }
            }
            markRepository.save(mark.toEntity())

            mark
        }
    }

    fun addModelToMark() {
        modelRepository.toString()
        //your logic here
    }

    fun findAll(): List<Mark> {
        return markRepository.findAll().asSequence().map {
            it.models?.size

            val mark = Mark(
                id = it.id,
                name = it.name,
                models = mutableListOf()
            )
            mark.models = it.models?.asSequence()?.map { Model(it.id, it.name, mark) }?.toList()

            mark
        }.toList()
    }
}


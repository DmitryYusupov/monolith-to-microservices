package ru.yusdm.monolithtomicro.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.domain.Mark
import ru.yusdm.monolithtomicro.domain.Model
import ru.yusdm.monolithtomicro.domain.toEntity
import ru.yusdm.monolithtomicro.repository.MarkRepository
import ru.yusdm.monolithtomicro.repository.ModelRepository

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


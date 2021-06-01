package ru.yusdm.monolithtomicro.mark.service.search

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.mark.domain.Mark
import ru.yusdm.monolithtomicro.mark.repository.MarkRepository
import ru.yusdm.monolithtomicro.model.domain.Model

@Service
@Transactional
class MarkSearchService(
    private val markRepository: MarkRepository,
) {

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


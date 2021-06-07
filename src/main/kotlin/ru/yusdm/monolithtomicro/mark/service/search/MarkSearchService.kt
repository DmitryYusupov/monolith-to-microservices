package ru.yusdm.monolithtomicro.mark.service.search

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.mark.domain.Mark
import ru.yusdm.monolithtomicro.mark.domain.Model
import ru.yusdm.monolithtomicro.mark.repository.MarkRepository
import ru.yusdm.monolithtomicro.model.api.ModelApiService

@Service
@Transactional
class MarkSearchService(
    private val markRepository: MarkRepository,
    private val modelApiService: ModelApiService
) {

    fun findAll(): List<Mark> {
        return markRepository.findAll().map {
            Mark(
                id = it.id,
                name = it.name,
                models = modelApiService.findByMarkId(it.id).map { Model(it.id, it.name) }
            )
        }
    }
}


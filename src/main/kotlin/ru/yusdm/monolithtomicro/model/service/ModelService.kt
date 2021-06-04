package ru.yusdm.monolithtomicro.model.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.model.domain.Model
import ru.yusdm.monolithtomicro.model.domain.toEntity
import ru.yusdm.monolithtomicro.model.entity.toModel
import ru.yusdm.monolithtomicro.model.repository.ModelRepository
import java.util.*

@Service
@Transactional
class ModelService(private val modelRepository: ModelRepository) {

    fun findByMarkId(markId: UUID): List<Model> {
        return modelRepository.findByMarkId(markId).asSequence().map { it.toModel() }.toList()
    }

    fun save(model: Model): Model {
        modelRepository.save(model.toEntity())

        return model
    }
}
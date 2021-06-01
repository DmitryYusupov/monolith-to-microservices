package ru.yusdm.monolithtomicro.model.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.model.repository.ModelRepository

@Service
@Transactional
class ModelService(private val modelRepository: ModelRepository) {

}
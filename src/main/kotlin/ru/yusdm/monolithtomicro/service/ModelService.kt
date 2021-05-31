package ru.yusdm.monolithtomicro.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.repository.ModelRepository

@Service
@Transactional
class ModelService(private val modelRepository: ModelRepository) {

}
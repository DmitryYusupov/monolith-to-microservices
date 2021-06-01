package ru.yusdm.monolithtomicro.model.api.http

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.model.service.ModelService

@Service
class ModelHttpService(private val modelService: ModelService) {
}
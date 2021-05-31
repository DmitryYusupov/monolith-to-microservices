package ru.yusdm.monolithtomicro.service.http

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.service.ModelService

@Service
class ModelHttpService(private val modelService: ModelService) {
}
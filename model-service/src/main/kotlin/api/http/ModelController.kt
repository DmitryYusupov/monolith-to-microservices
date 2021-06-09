package ru.yusdm.monolithtomicro.model.api.http

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/model")
class ModelController(private val modelHttpService: ModelHttpService) {
}
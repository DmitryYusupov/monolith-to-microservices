package ru.yusdm.monolithtomicro.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.monolithtomicro.service.http.ModelHttpService

@RestController
@RequestMapping("/api/model")
class ModelController(private val modelHttpService: ModelHttpService) {
}
package ru.yusdm.monolithtomicro.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.monolithtomicro.service.http.OrderHttpService

@RestController
@RequestMapping("/api/order")
class OrderController(private val orderHttpService: OrderHttpService) {
}
package ru.yusdm.monolithtomicro.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.monolithtomicro.dto.CreateOrderCommandDTO
import ru.yusdm.monolithtomicro.dto.OrderDTO
import ru.yusdm.monolithtomicro.service.http.OrderHttpService

@RestController
@RequestMapping("/api/order")
class OrderController(private val orderHttpService: OrderHttpService) {

    @PostMapping
    fun create(@RequestBody createOrderCommand: CreateOrderCommandDTO): OrderDTO? {
        return orderHttpService.create(createOrderCommand)
    }
}
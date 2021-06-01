package ru.yusdm.monolithtomicro.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.yusdm.monolithtomicro.dto.CreateOrderCommandDTO
import ru.yusdm.monolithtomicro.dto.OrderDTO
import ru.yusdm.monolithtomicro.service.http.OrderHttpService

@RestController
@RequestMapping("/api/order")
class OrderController(private val orderHttpService: OrderHttpService) {

    @PostMapping
    fun create(@RequestBody createOrderCommand: CreateOrderCommandDTO): ResponseEntity<OrderDTO> {
        return orderHttpService.create(createOrderCommand)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<OrderDTO>> {
        return orderHttpService.findAll()
    }
}
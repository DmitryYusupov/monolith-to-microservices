package ru.yusdm.monolithtomicro.order.api.http

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.yusdm.monolithtomicro.order.dto.CreateOrderCommandDTO
import ru.yusdm.monolithtomicro.order.dto.OrderDTO

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
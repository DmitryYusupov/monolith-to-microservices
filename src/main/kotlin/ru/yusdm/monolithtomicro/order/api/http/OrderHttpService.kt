package ru.yusdm.monolithtomicro.order.api.http

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.order.domain.toDTO
import ru.yusdm.monolithtomicro.order.dto.CreateOrderCommandDTO
import ru.yusdm.monolithtomicro.order.dto.OrderDTO
import ru.yusdm.monolithtomicro.order.dto.toModel
import ru.yusdm.monolithtomicro.order.service.OrderService

@Service
class OrderHttpService(private val orderService: OrderService) {

    fun create(createOrderCommandDTO: CreateOrderCommandDTO): ResponseEntity<OrderDTO> {
        return ResponseEntity.ok(
            orderService.createOrder(createOrderCommandDTO.toModel()).toDTO()
        )
    }

    fun findAll(): ResponseEntity<List<OrderDTO>> {
        return ResponseEntity.ok(orderService.findAll().map { it.toDTO() })
    }

}
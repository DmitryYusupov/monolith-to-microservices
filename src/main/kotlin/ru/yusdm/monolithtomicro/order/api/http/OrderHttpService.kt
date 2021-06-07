package ru.yusdm.monolithtomicro.order.api.http

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.order.domain.toDTO
import ru.yusdm.monolithtomicro.order.dto.CreateOrderCommandDTO
import ru.yusdm.monolithtomicro.order.dto.OrderDTO
import ru.yusdm.monolithtomicro.order.dto.toModel
import ru.yusdm.monolithtomicro.order.service.edit.OrderEditService
import ru.yusdm.monolithtomicro.order.service.search.OrderSearchService

@Service
class OrderHttpService(
    private val orderEditService: OrderEditService,
    private val orderSearchService: OrderSearchService
    ) {

    fun create(createOrderCommandDTO: CreateOrderCommandDTO): ResponseEntity<OrderDTO> {
        return ResponseEntity.ok(
            orderEditService.create(createOrderCommandDTO.toModel()).toDTO()
        )
    }

    fun findAll(): ResponseEntity<List<OrderDTO>> {
        return ResponseEntity.ok(orderSearchService.findAll().map { it.toDTO() })
    }

}
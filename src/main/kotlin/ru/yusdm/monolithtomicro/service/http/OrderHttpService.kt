package ru.yusdm.monolithtomicro.service.http

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.domain.toDTO
import ru.yusdm.monolithtomicro.dto.CreateOrderCommandDTO
import ru.yusdm.monolithtomicro.dto.OrderDTO
import ru.yusdm.monolithtomicro.dto.toModel
import ru.yusdm.monolithtomicro.service.OrderService

@Service
class OrderHttpService(private val orderService: OrderService) {

    fun create(createOrderCommandDTO: CreateOrderCommandDTO): OrderDTO {
        return orderService.createOrder(createOrderCommandDTO.toModel()).toDTO()
    }

}
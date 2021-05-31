package ru.yusdm.monolithtomicro.service.http

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.service.OrderService

@Service
class OrderHttpService(private val orderService: OrderService) {
}
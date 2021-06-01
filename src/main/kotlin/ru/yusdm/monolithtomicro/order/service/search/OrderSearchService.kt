package ru.yusdm.monolithtomicro.order.service.search

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.order.domain.Order
import ru.yusdm.monolithtomicro.order.repository.OrderRepository
import ru.yusdm.monolithtomicro.order.service.common.buildOrder

@Service
@Transactional
class OrderSearchService(private val orderRepository: OrderRepository) {

    fun findAll(): List<Order> {
        return orderRepository.findAll().asSequence().map {
            buildOrder(it, it.model, it.user)
        }.toList()
    }

}
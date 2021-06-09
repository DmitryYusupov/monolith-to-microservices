package ru.yusdm.monolithtomicro.order.service.search

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.model.connector.ModelApiService
import ru.yusdm.monolithtomicro.order.domain.Model
import ru.yusdm.monolithtomicro.order.domain.Order
import ru.yusdm.monolithtomicro.order.domain.User
import ru.yusdm.monolithtomicro.order.entity.toDomain
import ru.yusdm.monolithtomicro.order.repository.OrderRepository
import ru.yusdm.monolithtomicro.user.connector.UserApiService

@Service
@Transactional
class OrderSearchService(
    private val orderRepository: OrderRepository,
    private val modelApiService: ModelApiService,
    private val userApiService: UserApiService
) {

    fun findAll(): List<Order> {
        return orderRepository.findAll().asSequence().map {
            it.toDomain(
                modelSupplier = {
                    with(modelApiService.getById(it)) { Model(id, name) }
                },
                userSupplier = {
                    with(userApiService.getById(it)) { User(id, lastName = lastName, name = name) }
                })
        }.toList()
    }

}
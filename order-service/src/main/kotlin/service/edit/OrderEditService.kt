package ru.yusdm.monolithtomicro.order.service.edit

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.order.domain.Order
import ru.yusdm.monolithtomicro.order.entity.OrderEntity
import ru.yusdm.monolithtomicro.order.entity.toDomain
import ru.yusdm.monolithtomicro.order.repository.OrderRepository
import java.util.*

@Service
@Transactional
class OrderEditService(
    private val orderRepository: OrderRepository,
) {

    fun create(createOrderCommand: CreateOrderCommand): Order {
        return if (createOrderCommand.priceInRur > 100_000) {
            createOrderWithHighestPriority(createOrderCommand)
        } else {
            createOrderWithNormalPriority(createOrderCommand)
        }
    }

    private fun createOrderWithHighestPriority(createOrderCommand: CreateOrderCommand): Order {
        val order = with(createOrderCommand) {
            OrderEntity(
                id = UUID.randomUUID(),
                modelId = modelId,
                userId = userId,
                description = description,
                price = priceInRur,
                priority = 10_000,
                finished = false
            )
        }

        orderRepository.save(order)
        return order.toDomain()
    }

    private fun createOrderWithNormalPriority(createOrderCommand: CreateOrderCommand): Order {

        val order = with(createOrderCommand) {
            OrderEntity(
                id = UUID.randomUUID(),
                modelId =  modelId,
                userId =  userId,
                description = description,
                price = priceInRur,
                priority = 10,
                finished = false
            )
        }
        orderRepository.save(order)

        return order.toDomain()
    }

}
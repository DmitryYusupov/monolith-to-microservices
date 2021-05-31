package ru.yusdm.monolithtomicro.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.domain.Order
import ru.yusdm.monolithtomicro.entity.ModelEntity
import ru.yusdm.monolithtomicro.entity.OrderEntity
import ru.yusdm.monolithtomicro.entity.UserEntity
import ru.yusdm.monolithtomicro.repository.MarkRepository
import ru.yusdm.monolithtomicro.repository.OrderRepository
import java.util.*
import javax.persistence.*

@Service
@Transactional
class OrderService(
    private val orderRepository: OrderRepository,
    private val markRepository: MarkRepository,
    private val modelRepository: MarkRepository,
    private val entityManager: EntityManager,
) {

    fun createOrder(createOrderCommand: CreateOrderCommand): Order? {
        return if (createOrderCommand.priceInRur > 100_000) {
            createOrderWithHighestPriority(createOrderCommand)
        } else {
            createOrderWithNormalPriority(createOrderCommand)
        }
    }

    private fun createOrderWithHighestPriority(createOrderCommand: CreateOrderCommand): Order? {
        val entity = with(createOrderCommand) {
            OrderEntity(
                id = UUID.randomUUID(),
                model = ModelEntity.createById(modelId),
                user = UserEntity.createById(userId),
                description = description,
                price = priceInRur,
                priority = 10_000,
                finished = false
            )
        }

        orderRepository.save(entity)

        return null
    }

    private fun createOrderWithNormalPriority(createOrderCommand: CreateOrderCommand): Order? {

        val entity = with(createOrderCommand) {
            OrderEntity(
                id = UUID.randomUUID(),
                model = entityManager.getReference(ModelEntity::class.java, modelId),
                user = entityManager.getReference(UserEntity::class.java, userId),
                description = description,
                price = priceInRur,
                priority = 10,
                finished = false
            )
        }

        orderRepository.save(entity)

        return null
    }


}
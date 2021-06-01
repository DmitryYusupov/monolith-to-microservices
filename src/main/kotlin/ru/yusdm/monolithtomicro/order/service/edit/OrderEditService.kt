package ru.yusdm.monolithtomicro.order.service.edit

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.model.entity.ModelEntity
import ru.yusdm.monolithtomicro.model.repository.ModelRepository
import ru.yusdm.monolithtomicro.order.domain.Order
import ru.yusdm.monolithtomicro.order.entity.OrderEntity
import ru.yusdm.monolithtomicro.order.repository.OrderRepository
import ru.yusdm.monolithtomicro.order.service.common.buildOrder
import ru.yusdm.monolithtomicro.user.entity.UserEntity
import ru.yusdm.monolithtomicro.user.repository.UserRepository
import java.util.*
import javax.persistence.*

@Service
@Transactional
class OrderEditService(
    private val orderRepository: OrderRepository,
    private val userRepository: UserRepository,
    private val modelRepository: ModelRepository,
    private val entityManager: EntityManager,
) {

    fun createOrder(createOrderCommand: CreateOrderCommand): Order {
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
                model = ModelEntity.createById(modelId),
                user = UserEntity.createById(userId),
                description = description,
                price = priceInRur,
                priority = 10_000,
                finished = false
            )
        }

        orderRepository.save(order)
        val model = modelRepository.getById(createOrderCommand.modelId)
        val user = userRepository.getById(createOrderCommand.userId)

        return buildOrder(order, model, user)
    }

    private fun createOrderWithNormalPriority(createOrderCommand: CreateOrderCommand): Order {

        val order = with(createOrderCommand) {
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
        orderRepository.save(order)
        val model = modelRepository.getById(createOrderCommand.modelId)
        val user = userRepository.getById(createOrderCommand.userId)

        return buildOrder(order, model, user)
    }

}
package ru.yusdm.monolithtomicro.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.domain.Mark
import ru.yusdm.monolithtomicro.domain.Model
import ru.yusdm.monolithtomicro.domain.Order
import ru.yusdm.monolithtomicro.domain.User
import ru.yusdm.monolithtomicro.entity.ModelEntity
import ru.yusdm.monolithtomicro.entity.OrderEntity
import ru.yusdm.monolithtomicro.entity.UserEntity
import ru.yusdm.monolithtomicro.repository.ModelRepository
import ru.yusdm.monolithtomicro.repository.OrderRepository
import ru.yusdm.monolithtomicro.repository.UserRepository
import java.util.*
import javax.persistence.*

@Service
@Transactional
class OrderService(
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

    private fun buildOrder(order: OrderEntity, model: ModelEntity, user: UserEntity): Order {
        return Order(
            id = order.id,
            model = with(model) {
                Model(id = id,
                    name = name,
                    with(mark) {
                        Mark(id = id, name = name)
                    })
            },
            user = with(user) {
                User(
                    id = id,
                    name = name,
                    lastName = lastName,
                    driverLicense = driverLicense,
                    registeredAt = registeredAt
                )
            },
            description = order.description,
            price = order.price,
            priority = order.priority
        )
    }


    fun findAll(): List<Order> {
        return orderRepository.findAll().asSequence().map {
            buildOrder(it, it.model, it.user)
        }.toList()
    }

}
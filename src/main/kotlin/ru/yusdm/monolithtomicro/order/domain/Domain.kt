package ru.yusdm.monolithtomicro.order.domain

import ru.yusdm.monolithtomicro.order.dto.OrderDTO
import java.time.LocalDateTime
import java.util.*

data class Order(
    val id: UUID,
    val model: Model,
    val user: User,
    val description: String,
    val price: Int,
    val priority: Int,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val finished: Boolean = false
)

data class Model(val id: UUID, val name: String)

data class User(val id: UUID, val lastName: String, val name: String)

fun Order.toDTO(): OrderDTO {
    return OrderDTO(
        id = this.id,
        modelId = this.model.id,
        modelName = this.model.name,
        userFIO = with(this.user) { "$lastName $name" },
        description = this.description,
        price = this.price,
        priority = this.priority,
        createdAt = this.createdAt,
        finished = this.finished
    )
}
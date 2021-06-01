package ru.yusdm.monolithtomicro.order.domain

import ru.yusdm.monolithtomicro.model.domain.Model
import ru.yusdm.monolithtomicro.order.dto.OrderDTO
import ru.yusdm.monolithtomicro.user.domain.User
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
package ru.yusdm.monolithtomicro.order.entity

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import ru.yusdm.monolithtomicro.common.UNDEFINED_STR
import ru.yusdm.monolithtomicro.order.domain.Model
import ru.yusdm.monolithtomicro.order.domain.Order
import ru.yusdm.monolithtomicro.order.domain.User
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "orders")
class OrderEntity(

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    var id: UUID = DEFAULT_ID,

    @Column(name = "model_id", nullable = false)
    var modelId: UUID,

    @Column(name = "user_id", nullable = false)
    var userId: UUID,

    @Column(name = "price")
    var price: Int,

    @Column(name = "priority")
    var priority: Int,

    @Column(name = "description")
    var description: String,

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "finished")
    var finished: Boolean
)

fun OrderEntity.toDomain(
    modelSupplier: (modelId: UUID) -> Model = {
        Model(id = modelId, name = UNDEFINED_STR)
    },
    userSupplier: (userId: UUID) -> User = {
        User(id = userId, lastName = UNDEFINED_STR, name = UNDEFINED_STR)
    }
): Order {
    return Order(
        id = id,
        model = modelSupplier.invoke(this.modelId),
        user = userSupplier.invoke(this.userId),
        description = description,
        price = price,
        priority = priority,
        createdAt = createdAt,
        finished = finished
    )
}

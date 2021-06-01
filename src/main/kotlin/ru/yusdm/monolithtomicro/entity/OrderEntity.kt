package ru.yusdm.monolithtomicro.entity

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
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

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    var model: ModelEntity,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: UserEntity,

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

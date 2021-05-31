package ru.yusdm.monolithtomicro.entity

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
    private var user: UserEntity
)

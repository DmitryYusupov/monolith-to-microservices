package ru.yusdm.monolithtomicro.user.domain

import java.time.LocalDateTime
import java.util.*

data class User(
    val id: UUID,
    val name: String,
    val lastName: String,
    val driverLicense: String,
    val orders: List<Order>? = null,
    val registeredAt: LocalDateTime = LocalDateTime.now()
)

data class Order(
    val id: UUID,
    val modelName: String,
    val price: Int,
    val finished: Boolean
)
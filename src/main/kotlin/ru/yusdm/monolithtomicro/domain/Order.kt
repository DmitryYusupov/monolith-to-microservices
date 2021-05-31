package ru.yusdm.monolithtomicro.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Order(
    val id: UUID,
    val model: Model,
    val user: User,
    val description: String,
    val price: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val finished: Boolean = false
)

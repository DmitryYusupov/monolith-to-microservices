package ru.yusdm.monolithtomicro.order.dto

import java.time.LocalDateTime
import java.util.*

data class OrderDTO (
    val id: UUID,
    val modelId: UUID,
    val modelName: String,
    val userFIO: String,
    val description: String,
    val price: Int,
    val priority: Int,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val finished: Boolean = false
)
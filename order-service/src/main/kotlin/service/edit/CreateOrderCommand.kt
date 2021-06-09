package ru.yusdm.monolithtomicro.order.service.edit

import java.util.*

data class CreateOrderCommand(
    val userId: UUID,
    val modelId: UUID,
    val description: String,
    val priceInRur: Int
)

package ru.yusdm.monolithtomicro.dto

import ru.yusdm.monolithtomicro.service.CreateOrderCommand
import java.util.*

data class CreateOrderCommandDTO(
    val userId: UUID,
    val modelId: UUID,
    val description: String,
    val price: Int,
    val currency: String
)

fun CreateOrderCommandDTO.toModel(): CreateOrderCommand {
    return CreateOrderCommand(
        userId = this.userId,
        modelId = modelId,
        description = description,
        priceInRur = price * 100
    )
}
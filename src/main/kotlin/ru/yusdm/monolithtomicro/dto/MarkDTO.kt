package ru.yusdm.monolithtomicro.dto

import java.util.*

data class MarkDTO(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val models: List<ModelDTO>? = null
)

package ru.yusdm.monolithtomicro.mark.dto

import ru.yusdm.monolithtomicro.model.dto.ModelDTO
import java.util.*

data class MarkDTO(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val models: List<ModelDTO>? = null
)

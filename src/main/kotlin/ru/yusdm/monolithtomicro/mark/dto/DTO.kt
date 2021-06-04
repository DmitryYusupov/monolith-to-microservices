package ru.yusdm.monolithtomicro.mark.dto

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import java.util.*

data class MarkDTO(
    val id: UUID = DEFAULT_ID,
    val name: String,
    val models: List<ModelDTO>? = null
)

data class ModelDTO(val id: UUID, val name: String)
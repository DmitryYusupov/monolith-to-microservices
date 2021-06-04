package ru.yusdm.monolithtomicro.model.domain

import ru.yusdm.monolithtomicro.model.dto.ModelDTO
import ru.yusdm.monolithtomicro.model.entity.ModelEntity
import java.util.*

data class Model(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val mark: Mark
)

data class Mark(
    val id: UUID = UUID.randomUUID(),
    val name: String,
)

fun Model.toEntity(markId: UUID): ModelEntity {
    return ModelEntity(
        id = this.id,
        markId = markId,
        name = this.name,
        orders = mutableListOf()
    )
}

fun Model.toDTO(): ModelDTO = ModelDTO(name = this.name)
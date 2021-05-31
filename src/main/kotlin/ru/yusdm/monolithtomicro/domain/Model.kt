package ru.yusdm.monolithtomicro.domain

import ru.yusdm.monolithtomicro.dto.ModelDTO
import ru.yusdm.monolithtomicro.entity.MarkEntity
import ru.yusdm.monolithtomicro.entity.ModelEntity
import java.util.*

data class Model(
    val id: UUID,
    val name: String,
    val mark: Mark
)

fun Model.toEntity(markEntity: MarkEntity): ModelEntity {
    return ModelEntity(
        id = this.id,
        mark = markEntity,
        name = this.name,
        orders = mutableListOf()
    )
}

fun Model.toDTO(): ModelDTO = ModelDTO(name = this.name)
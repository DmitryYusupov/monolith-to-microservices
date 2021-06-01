package ru.yusdm.monolithtomicro.model.domain

import ru.yusdm.monolithtomicro.model.dto.ModelDTO
import ru.yusdm.monolithtomicro.mark.entity.MarkEntity
import ru.yusdm.monolithtomicro.model.entity.ModelEntity
import java.util.*

data class Model(
    val id: UUID = UUID.randomUUID(),
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
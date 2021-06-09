package ru.yusdm.monolithtomicro.catalog.domain

import ru.yusdm.monolithtomicro.catalog.dto.MarkDTO
import ru.yusdm.monolithtomicro.catalog.dto.ModelDTO
import ru.yusdm.monolithtomicro.catalog.entity.MarkEntity
import ru.yusdm.monolithtomicro.catalog.entity.ModelEntity
import java.util.*

data class Mark(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    var models: List<Model>? = null
)

fun Mark.toEntity(): MarkEntity {
    val mark = MarkEntity(
        id = this.id,
        name = this.name,
        models = mutableListOf()
    )

    mark.models = this.models?.map { it.toEntity(mark) }?.toMutableList()

    return mark
}

fun Mark.toDTO(): MarkDTO {
    return MarkDTO(
        id = this.id,
        name = this.name,
        models = this.models?.map { it.toDTO() }
    )
}

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
    )
}

fun Model.toDTO(): ModelDTO = ModelDTO(name = this.name)
package ru.yusdm.monolithtomicro.mark.domain

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import ru.yusdm.monolithtomicro.mark.dto.MarkDTO
import ru.yusdm.monolithtomicro.mark.dto.ModelDTO
import ru.yusdm.monolithtomicro.mark.entity.MarkEntity
import java.util.*

data class Mark(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    var models: List<Model> = emptyList()
)

data class Model(val id: UUID = DEFAULT_ID, val name: String)

fun Mark.toEntity(): MarkEntity = MarkEntity(
    id = this.id,
    name = this.name,
)

fun Mark.toDTO(): MarkDTO {
    return MarkDTO(
        id = this.id,
        name = this.name,
        models = this.models.map { it.toDTO() }
    )
}

fun Model.toDTO(): ModelDTO {
    return ModelDTO(id, name)
}
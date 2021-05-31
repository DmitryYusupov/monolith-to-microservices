package ru.yusdm.monolithtomicro.domain

import ru.yusdm.monolithtomicro.dto.MarkDTO
import ru.yusdm.monolithtomicro.entity.MarkEntity
import java.util.*

data class Mark(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val models: List<Model>? = null
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
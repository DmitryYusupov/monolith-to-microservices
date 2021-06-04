package ru.yusdm.monolithtomicro.model.domain

import ru.yusdm.monolithtomicro.model.dto.DTO
import ru.yusdm.monolithtomicro.model.entity.ModelEntity
import java.util.*

data class Model(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val markId: UUID,
    val orderIds: Set<UUID> = emptySet()
)

fun Model.toEntity(): ModelEntity {
    return ModelEntity(
        id = this.id,
        markId = this.markId,
        name = this.name,
    )
}

fun Model.toDTO(): DTO = DTO(name = this.name)
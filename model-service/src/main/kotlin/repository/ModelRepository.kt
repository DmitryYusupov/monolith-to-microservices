package ru.yusdm.monolithtomicro.model.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.model.entity.ModelEntity
import java.util.*

interface ModelRepository: JpaRepository<ModelEntity, UUID> {
    fun findByMarkId(markId: UUID): List<ModelEntity>
}
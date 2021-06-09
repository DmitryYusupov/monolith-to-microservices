package ru.yusdm.monolithtomicro.catalog.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.catalog.entity.ModelEntity
import java.util.*

interface ModelRepository: JpaRepository<ModelEntity, UUID> {
    fun findByMarkId(markId: UUID): List<ModelEntity>
}
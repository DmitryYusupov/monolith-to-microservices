package ru.yusdm.monolithtomicro.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.model.entity.ModelEntity
import java.util.*

interface ModelRepository: JpaRepository<ModelEntity, UUID>
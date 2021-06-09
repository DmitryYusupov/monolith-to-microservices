package ru.yusdm.monolithtomicro.catalog.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.catalog.entity.MarkEntity
import java.util.*

interface MarkRepository: JpaRepository<MarkEntity, UUID>
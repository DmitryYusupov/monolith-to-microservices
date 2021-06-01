package ru.yusdm.monolithtomicro.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.mark.entity.MarkEntity
import java.util.*

interface MarkRepository: JpaRepository<MarkEntity, UUID>
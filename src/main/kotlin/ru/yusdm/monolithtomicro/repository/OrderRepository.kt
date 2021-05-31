package ru.yusdm.monolithtomicro.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.entity.OrderEntity
import java.util.*

interface OrderRepository: JpaRepository<OrderEntity, UUID>
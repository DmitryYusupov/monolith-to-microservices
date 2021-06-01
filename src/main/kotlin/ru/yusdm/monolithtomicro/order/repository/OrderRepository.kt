package ru.yusdm.monolithtomicro.order.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.order.entity.OrderEntity
import java.util.*

interface OrderRepository: JpaRepository<OrderEntity, UUID>
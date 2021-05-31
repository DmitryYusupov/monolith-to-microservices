package ru.yusdm.monolithtomicro.domain

import java.time.LocalDateTime
import java.util.*

data class User(
    val id: UUID,
    val name: String,
    val lastName: String,
    val driverLicense: String,
    val registeredAt: LocalDateTime = LocalDateTime.now()
    )
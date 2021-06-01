package ru.yusdm.monolithtomicro.service.util

import java.time.LocalDateTime

fun LocalDateTime.asString() : String {
    return this.toString()
}
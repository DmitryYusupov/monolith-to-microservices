package ru.yusdm.monolithtomicro.common

import java.time.LocalDate
import java.time.LocalDateTime

fun LocalDateTime.asString() : String {
    return this.toString()
}

fun LocalDate.asString(): String {
    return this.toString()
}
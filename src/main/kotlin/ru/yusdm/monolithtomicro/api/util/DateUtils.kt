package ru.yusdm.monolithtomicro.api.util

import java.time.LocalDate

fun LocalDate.asString(): String {
    return this.toString()
}
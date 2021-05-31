package ru.yusdm.monolithtomicro.service

import java.util.*

data class CreateMarkCommand(
    val id: UUID,
    val name: String,
    val models: List<Model>?
) {

    data class Model(val name: String)
}
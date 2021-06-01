package ru.yusdm.monolithtomicro.service

data class CreateMarkCommand(
    val name: String,
    val models: List<Model>?
) {

    data class Model(val name: String)
}
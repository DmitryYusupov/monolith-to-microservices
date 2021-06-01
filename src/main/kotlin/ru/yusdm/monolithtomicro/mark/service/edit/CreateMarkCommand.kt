package ru.yusdm.monolithtomicro.mark.service.edit

data class CreateMarkCommand(
    val name: String,
    val models: List<Model>?
) {

    data class Model(val name: String)
}
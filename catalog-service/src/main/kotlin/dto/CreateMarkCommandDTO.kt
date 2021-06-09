package ru.yusdm.monolithtomicro.catalog.dto

import ru.yusdm.monolithtomicro.catalog.service.edit.CreateMarkCommand

data class CreateMarkCommandDTO(
    val name: String,
    val models: List<Model>?
) {
    data class Model(val name: String)
}

fun CreateMarkCommandDTO.toCreateMarkCommandModel(): CreateMarkCommand {
    return CreateMarkCommand(
        name = this.name,
        models = this.models?.map {
            CreateMarkCommand.Model(it.name)
        }
    )
}


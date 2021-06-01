package ru.yusdm.monolithtomicro.mark.dto

import ru.yusdm.monolithtomicro.service.CreateMarkCommand

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


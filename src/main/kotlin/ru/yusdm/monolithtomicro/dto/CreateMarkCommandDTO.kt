package ru.yusdm.monolithtomicro.dto

import ru.yusdm.monolithtomicro.service.CreateMarkCommand
import java.util.*

data class CreateMarkCommandDTO(
    val id: UUID,
    val name: String,
    val models: List<Model>?
) {

    data class Model(val name: String)
}

fun CreateMarkCommandDTO.toCreateMarkCommandModel(): CreateMarkCommand {
    return CreateMarkCommand(
        id = this.id,
        name = this.name,
        models = this.models?.map {
            CreateMarkCommand.Model(it.name)
        }
    )
}


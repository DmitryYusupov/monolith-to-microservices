package ru.yusdm.monolithtomicro.model.service

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.model.facade.Model
import ru.yusdm.monolithtomicro.model.facade.ModelFacade
import java.util.*

@Service
class DefaultModelFacade(private val modelService: ModelService): ModelFacade{

    override fun addModel(model: Model, markId: UUID) {
        println("Add mark to model")
    }

    override fun findModelsByMarkId(markId: UUID): List<Model> {
       return modelService.findByMarkId(markId).map { Model(id = it.id, name = it.name) }
    }
}
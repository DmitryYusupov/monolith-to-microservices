package ru.yusdm.monolithtomicro.model.facade

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import java.util.*


data class Model(val id: UUID = DEFAULT_ID,val name: String)

interface ModelFacade {
    fun addModel(model: Model, markId: UUID)
    fun findModelsByMarkId(markId: UUID): List<Model>
}
package ru.yusdm.monolithtomicro.model.api

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import java.util.*


data class Model(val id: UUID = DEFAULT_ID, val markId:UUID = DEFAULT_ID, val name: String)

interface ModelApiService {

    fun addModel(model: Model): Model

    fun findModelsByMarkId(markId: UUID): List<Model>
}
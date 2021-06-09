package ru.yusdm.monolithtomicro.model.connector

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import java.util.*

data class Model(val id: UUID = DEFAULT_ID, val markId: UUID = DEFAULT_ID, val name: String)

interface ModelApiService {

    fun save(model: Model): Model

    fun findByMarkId(markId: UUID): List<Model>

    fun getById(modelId: UUID): Model
}
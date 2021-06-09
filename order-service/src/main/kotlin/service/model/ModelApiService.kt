package ru.yusdm.monolithtomicro.order.service.model

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import java.util.*

data class Model(val id: UUID = DEFAULT_ID, val markId: UUID = DEFAULT_ID, val name: String)

val mockModel = Model(UUID.randomUUID(), markId = UUID.randomUUID(), name = "MockName")

@Service
class ModelApiService(private val restTemplate: RestTemplate) {

    fun getById(modelId: UUID): Model {
        //todo implement services interaction

        return mockModel
    }
}
package ru.yusdm.monolithtomicro.model.service

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.model.api.Model
import ru.yusdm.monolithtomicro.model.api.ModelApiService
import ru.yusdm.monolithtomicro.model.domain.Model as ModelDomain
import java.util.*

@Service
class DefaultModelApiService(private val modelService: ModelService) : ModelApiService {

    override fun save(model: Model): Model {
        return modelService.save(ModelDomain(name = model.name, markId = model.markId)).toModelApi()
    }

    override fun findByMarkId(markId: UUID): List<Model> {
        return modelService.findByMarkId(markId).map { it.toModelApi() }
    }

    override fun getById(modelId: UUID): Model {
        return modelService.getById(modelId).toModelApi()
    }
}

private fun ModelDomain.toModelApi(): Model {
    return Model(id = this.id, name = this.name, markId = this.markId)
}
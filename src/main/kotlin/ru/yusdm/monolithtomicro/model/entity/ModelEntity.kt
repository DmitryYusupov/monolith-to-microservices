package ru.yusdm.monolithtomicro.model.entity

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import ru.yusdm.monolithtomicro.common.UNDEFINED_STR
import ru.yusdm.monolithtomicro.model.domain.Model
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "model")
class ModelEntity(

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    var id: UUID = DEFAULT_ID,

    @Column(name = "mark_id")
    var markId: UUID,

    @Column(name = "name", nullable = false)
    var name: String,
) {
    companion object {
        fun createById(id: UUID) = ModelEntity(id = id, markId = DEFAULT_ID, name = UNDEFINED_STR)
    }
}

fun ModelEntity.toModel() = Model(id = id, name = name, markId = markId)
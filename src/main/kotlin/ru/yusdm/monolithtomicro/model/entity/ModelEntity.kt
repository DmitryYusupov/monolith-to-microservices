package ru.yusdm.monolithtomicro.model.entity

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import ru.yusdm.monolithtomicro.common.UNDEFINED_STR
import ru.yusdm.monolithtomicro.model.domain.Mark
import ru.yusdm.monolithtomicro.model.domain.Model
import ru.yusdm.monolithtomicro.order.entity.OrderEntity
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = [CascadeType.ALL])
    var orders: MutableList<OrderEntity>? = null

) {
    companion object {
        fun createById(id: UUID): ModelEntity {
            return ModelEntity(
                id = id,
                markId = DEFAULT_ID,
                name = UNDEFINED_STR
            )
        }
    }

}

fun ModelEntity.toModel(): Model {
    return Model(
        id = id,
        name = name,
        mark = Mark(id = markId, name = UNDEFINED_STR)
    )
}
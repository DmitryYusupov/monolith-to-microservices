package ru.yusdm.monolithtomicro.model.entity

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import ru.yusdm.monolithtomicro.common.UNDEFINED_STR
import ru.yusdm.monolithtomicro.mark.entity.MarkEntity
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

    @ManyToOne
    @JoinColumn(name = "mark_id")
    var mark: MarkEntity,

    @Column(name = "name", nullable = false)
    var name: String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = [CascadeType.ALL])
    var orders: MutableList<OrderEntity>? = null

) {
    companion object {
        fun createById(id: UUID): ModelEntity {
            return ModelEntity(
                id = id,
                mark = MarkEntity(name = UNDEFINED_STR),
                name = UNDEFINED_STR
            )
        }
    }

}
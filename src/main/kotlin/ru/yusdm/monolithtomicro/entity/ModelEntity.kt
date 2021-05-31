package ru.yusdm.monolithtomicro.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "model")
class ModelEntity (

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    var id: UUID = DEFAULT_ID,

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private var mark: MarkEntity,

    @Column(name = "name", nullable = false)
    var name: String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = [CascadeType.ALL])
    var orders: MutableList<OrderEntity>? = null

) {
    companion object {
        fun createById(id: UUID): ModelEntity {
            return ModelEntity(
                id = id,
                mark = MarkEntity(name ="NA"),
                name = "NA"
            )
        }
    }

}
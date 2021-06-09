package ru.yusdm.monolithtomicro.catalog.entity

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "mark")
class MarkEntity (

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    var id: UUID = DEFAULT_ID,

    @Column(name = "name")
    var name: String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mark", cascade = [CascadeType.ALL])
    var models: MutableList<ModelEntity>? = null
)

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

)
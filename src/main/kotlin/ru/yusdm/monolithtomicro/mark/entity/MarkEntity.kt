package ru.yusdm.monolithtomicro.mark.entity

import ru.yusdm.monolithtomicro.entity.DEFAULT_ID
import ru.yusdm.monolithtomicro.model.entity.ModelEntity
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
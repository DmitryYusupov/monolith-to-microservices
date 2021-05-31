package ru.yusdm.monolithtomicro.entity

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mark")
    var models: MutableList<ModelEntity>? = null
)
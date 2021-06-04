package ru.yusdm.monolithtomicro.mark.entity

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

)
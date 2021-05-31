package ru.yusdm.monolithtomicro.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    var id: UUID = DEFAULT_ID,

    @Column(name = "name")
    var name: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "driver_license")
    var driverLicense: String,

    @Column(name = "registered_at")
    var registeredAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = [CascadeType.ALL])
    var orders: MutableList<OrderEntity> = mutableListOf()

) {
    companion object {
        fun createById(id: UUID): UserEntity {
            return UserEntity(
                id = id,
                name = "NONE",
                lastName = "NONE",
                driverLicense = "NONE",
            )
        }
    }
}
package ru.yusdm.monolithtomicro.user.entity

import ru.yusdm.monolithtomicro.common.DEFAULT_ID
import ru.yusdm.monolithtomicro.user.domain.Order
import ru.yusdm.monolithtomicro.user.domain.User
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
)

fun UserEntity.toDomain(ordersSupplier: ((userId: UUID) -> List<Order>?)? = null): User {
    return User(
        id = id,
        name = name,
        lastName = lastName,
        orders = ordersSupplier?.invoke(id),
        driverLicense = driverLicense,
        registeredAt = registeredAt
    )
}

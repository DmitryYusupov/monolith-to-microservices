package ru.yusdm.monolithtomicro.order.service.user

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDateTime
import java.util.*

enum class UserData {
    ORDER
}

data class User(
    val id: UUID,
    val name: String,
    val lastName: String,
    val driverLicense: String,
    val orders: List<Order>? = null,
    val registeredAt: LocalDateTime = LocalDateTime.now()
)

data class Order(
    val id: UUID,
    val modelName: String,
    val price: Int,
    val finished: Boolean
)

private val mockUser = User(
    UUID.randomUUID(), name = "Mock_name", lastName = "Mock_lastName", driverLicense = "123"
)

@Service
class UserApiService(private val restTemplate: RestTemplate) {
    fun getById(uuid: UUID, fetchFields: Set<UserData> = emptySet()): User {
        return mockUser
    }
}
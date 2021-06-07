package ru.yusdm.monolithtomicro.user.service

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.user.api.User
import ru.yusdm.monolithtomicro.user.api.UserApiService
import ru.yusdm.monolithtomicro.user.api.UserData
import ru.yusdm.monolithtomicro.user.domain.User as UserDomain
import java.util.*

@Service
class DefaultUserApiService(
    private val userService: UserService
) : UserApiService {

    override fun getById(id: UUID, fetchFields: Set<UserData>): User {
        return userService.getById(id).toModelApi()
    }

}

private fun UserDomain.toModelApi(): User {
    return User(
        id = id,
        name = name,
        lastName = lastName,
        driverLicense = driverLicense,
        registeredAt = registeredAt,
    )
}
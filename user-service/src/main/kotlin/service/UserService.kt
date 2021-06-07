package ru.yusdm.monolithtomicro.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.user.domain.User
import ru.yusdm.monolithtomicro.user.entity.toDomain
import ru.yusdm.monolithtomicro.user.repository.UserRepository
import java.util.*

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository
) {

    fun getById(id: UUID): User {
        return userRepository.getById(id).toDomain()
    }

    fun getByIdWithOrders(id: UUID): User {
        return userRepository.getById(id).toDomain()
    }

}
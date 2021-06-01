package ru.yusdm.monolithtomicro.user.api.http

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.user.service.UserService

@Service
class UserHttpService(private val userService: UserService) {
}
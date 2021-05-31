package ru.yusdm.monolithtomicro.service.http

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.service.UserService

@Service
class UserHttpService(private val userService: UserService) {
}
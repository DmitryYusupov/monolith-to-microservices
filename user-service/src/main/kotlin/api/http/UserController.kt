package ru.yusdm.monolithtomicro.user.api.http

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(private val userHttpService: UserHttpService) {
}
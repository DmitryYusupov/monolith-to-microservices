package ru.yusdm.monolithtomicro.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.monolithtomicro.service.http.UserHttpService

@RestController
@RequestMapping("/api/user")
class UserController(private val userHttpService: UserHttpService) {
}
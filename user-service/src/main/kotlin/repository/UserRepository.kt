package ru.yusdm.monolithtomicro.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.user.entity.UserEntity
import java.util.*

interface UserRepository: JpaRepository<UserEntity, UUID>
package ru.yusdm.monolithtomicro.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.monolithtomicro.entity.UserEntity
import java.util.*

interface UserRepository: JpaRepository<UserEntity, UUID>
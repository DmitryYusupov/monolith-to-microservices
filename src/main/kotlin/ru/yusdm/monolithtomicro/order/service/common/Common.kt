package ru.yusdm.monolithtomicro.order.service.common

import ru.yusdm.monolithtomicro.model.domain.Model
import ru.yusdm.monolithtomicro.model.entity.ModelEntity
import ru.yusdm.monolithtomicro.order.domain.Order
import ru.yusdm.monolithtomicro.order.entity.OrderEntity
import ru.yusdm.monolithtomicro.user.domain.User
import ru.yusdm.monolithtomicro.user.entity.UserEntity

fun buildOrder(order: OrderEntity, model: ModelEntity, user: UserEntity): Order {
    return Order(
        id = order.id,
        model = with(model) {
            Model(id = id,
                name = name,
                with(mark) {
                    Mark(id = id, name = name)
                })
        },
        user = with(user) {
            User(
                id = id,
                name = name,
                lastName = lastName,
                driverLicense = driverLicense,
                registeredAt = registeredAt
            )
        },
        description = order.description,
        price = order.price,
        priority = order.priority
    )
}

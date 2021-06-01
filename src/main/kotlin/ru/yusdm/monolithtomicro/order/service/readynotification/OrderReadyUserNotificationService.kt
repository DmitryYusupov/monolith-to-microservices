package ru.yusdm.monolithtomicro.order.service.readynotification

import org.springframework.stereotype.Service
import ru.yusdm.monolithtomicro.order.domain.Order
import ru.yusdm.monolithtomicro.user.domain.User

enum class Chanel {
    SMS, EMAIL, TELEGRAM
}

@Service
class OrderReadyUserNotificationService {

    private fun notificateUserAboutOrderIsReady(chanel: Chanel, user: User, order: Order) {
        when (chanel) {
            Chanel.SMS -> notificateUserAboutOrderIsReadyBySms()
            Chanel.EMAIL -> notificateUserAboutOrderIsReadyByEmail()
            Chanel.TELEGRAM -> notificateUserAboutOrderIsReadyByTelegram()
        }
    }

    private fun notificateUserAboutOrderIsReadyBySms() {
        //todo
    }

    private fun notificateUserAboutOrderIsReadyByEmail() {
        //todo
    }

    private fun notificateUserAboutOrderIsReadyByTelegram() {
        //
    }

}
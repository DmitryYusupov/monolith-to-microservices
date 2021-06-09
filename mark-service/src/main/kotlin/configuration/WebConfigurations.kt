package ru.yusdm.monolithtomicro.mark.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class WebConfigurations {

    @Bean
    fun restTemplate() = RestTemplate()

}
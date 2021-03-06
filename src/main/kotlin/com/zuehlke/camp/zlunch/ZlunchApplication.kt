package com.zuehlke.camp.zlunch

import com.zuehlke.camp.zlunch.services.LunchService
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import org.springframework.web.reactive.function.server.router

fun main(args: Array<String>) {
    runApplication<ZlunchApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}

@SpringBootApplication
class ZlunchApplication {
    @Bean
    fun routes(lunchService: LunchService) = router {
        GET("/lunchEvents") { ok().bodyToServerSentEvents(lunchService.steamAll()) }
    }
}

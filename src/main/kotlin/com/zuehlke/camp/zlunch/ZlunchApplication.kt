package com.zuehlke.camp.zlunch

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<ZlunchApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}

@SpringBootApplication
class ZlunchApplication {
//    @Bean
//    fun routes(lunchService: LunchService) = router {
//        GET("/lunches") { ok().bodyToServerSentEvents(lunchService.findAll()) }
//    }
}

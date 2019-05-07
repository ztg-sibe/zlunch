package com.zuehlke.camp.zlunch

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZlunchApplication

fun main(args: Array<String>) {
    runApplication<ZlunchApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}

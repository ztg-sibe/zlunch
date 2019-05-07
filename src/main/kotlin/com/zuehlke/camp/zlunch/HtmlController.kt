package com.zuehlke.camp.zlunch

import com.zuehlke.camp.zlunch.services.LunchRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(val lunchRepository: LunchRepository) {

    @GetMapping("/")
    fun start(model: Model): String {
        model["title"] = "Hello World"
        model["lunches"] = lunchRepository.findAll()
        return "start"
    }

}

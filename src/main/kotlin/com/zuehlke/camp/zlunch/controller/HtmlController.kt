package com.zuehlke.camp.zlunch.controller


import com.zuehlke.camp.zlunch.services.LunchRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable


@Controller
class HtmlController(val lunchRepository: LunchRepository) {

    @GetMapping("/")
    fun start(model: Model): String {
        model["lunches"] = ReactiveDataDriverContextVariable(lunchRepository.findAll(), 1);
        return "index"
    }

}

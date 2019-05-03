package com.zuehlke.camp.zlunch

import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HtmlController {

    @GetMapping("/")
    fun start(model: Model): String {
        model["title"] = "Hello World"
        return "start"
    }

    @GetMapping("/test")
    fun test() : InlineClass {
        return InlineClass("möp", 12)
    }

    class InlineClass(val name: String, val age: Int)

}

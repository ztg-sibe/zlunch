package com.zuehlke.camp.zlunch

import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.services.LunchService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class LunchController(val lunchService: LunchService) {


    @PostMapping("/lunches")
    fun createLunch(@RequestBody lunch: Mono<Lunch>): Mono<Lunch> {
        return lunchService.createLunch(lunch);
    }
}

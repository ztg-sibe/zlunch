package com.zuehlke.camp.zlunch

import com.zuehlke.camp.zlunch.entity.Participation
import com.zuehlke.camp.zlunch.services.LunchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class LunchController(val lunchService: LunchService) {


    @GetMapping("/lunches/{id}/participations")
    fun getParticipations(@PathVariable("id") id: String): Flux<Participation> {
        return lunchService.getParticipationByLunch(id);
    }

//    @PostMapping("/lunches")
//    fun createLunch(@RequestBody lunch: Mono<Lunch>): Mono<Lunch> {
//        return lunchService.createLunch(lunch);
//    }
}

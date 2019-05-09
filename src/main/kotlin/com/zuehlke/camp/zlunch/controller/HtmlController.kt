package com.zuehlke.camp.zlunch.controller


import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.services.LocationRepository
import com.zuehlke.camp.zlunch.services.LunchRepository
import com.zuehlke.camp.zlunch.services.LunchService
import com.zuehlke.camp.zlunch.services.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.reactive.result.view.RedirectView
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable
import reactor.core.publisher.Mono


@Controller
class HtmlController(val lunchRepository: LunchRepository,
                     val locationRepository: LocationRepository,
                     val userRepository: UserRepository,
                     val lunchService: LunchService) {

    @GetMapping("/")
    fun start(model: Model): String {
        model["lunches"] = ReactiveDataDriverContextVariable(lunchRepository.streamAllBy(), 1);
        model["locations"] = locationRepository.findAll()
        model["users"] = userRepository.findAll()
        model["lunch"] = LunchForm()
        return "index"
    }

    data class LunchForm(val name: String = "", val meetingPoint: String = "", val locationId: String = "")

    @PostMapping("/")
    fun post(lunch: LunchForm): Mono<RedirectView> {
        return locationRepository.findById(lunch.locationId)
                .map { location ->
                    Lunch(
                            name = lunch.name,
                            meetingPoint = lunch.meetingPoint,
                            location = location)
                }
                .flatMap(lunchService::createLunch).flatMap { Mono.just(RedirectView("/")) }
    }
}

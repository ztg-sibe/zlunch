package com.zuehlke.camp.zlunch.services

import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.entity.LunchCreatedEvent
import com.zuehlke.camp.zlunch.entity.Participation
import com.zuehlke.camp.zlunch.entity.User
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class LunchService(val lunchRepository: LunchRepository,
                   val participationRepository: ParticipationRepository,
                   val lunchCreatedEventRepository: LunchCreatedEventRepository) {
    fun findAll(): Flux<Lunch> {
        return lunchRepository.findAllByDateIs(LocalDate.now(), Sort.by("startTime").ascending().and(Sort.by("name").ascending()))
    }

    fun createLunch(lunch: Lunch): Mono<Lunch> {
        return lunchRepository.save(lunch)
                .doOnNext { l -> lunchCreatedEventRepository.save(LunchCreatedEvent(l)).subscribe { print("yay") } }
                .log()
    }

    fun participateLunch(user: Mono<User>, lunch: Mono<Lunch>): Mono<Participation> {
        return user
                .zipWith(lunch) { u, l -> Participation(u, l) }
                .flatMap { s -> participationRepository.save(s) }
                .log()
    }

    fun steamAll(): Flux<LunchCreatedEvent> {
        return lunchCreatedEventRepository.streamAllByCreatedIsAfter(LocalDateTime.now())
    }

    fun getParticipationByLunch(id: String): Flux<Participation> {
        return participationRepository.findAllByLunchId(id)
    }
}

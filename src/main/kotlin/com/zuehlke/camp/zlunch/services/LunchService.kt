package com.zuehlke.camp.zlunch.services

import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.entity.Participation
import com.zuehlke.camp.zlunch.entity.User
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class LunchService(val lunchRepository: LunchRepository,
                   val participationRepository: ParticipationRepository) {
    fun findAll(): Flux<Lunch> {
        return lunchRepository.findAll(Sort.by("startTime").ascending())
    }

    fun createLunch(lunch: Lunch): Mono<Lunch> {
        return lunchRepository.save(lunch)
                .log()
    }

    fun participateLunch(user: Mono<User>, lunch: Mono<Lunch>): Mono<Participation> {
        return user
                .zipWith(lunch) { u, l -> Participation(u, l) }
                .flatMap { s -> participationRepository.save(s) }
                .log()
    }

    fun steamAll(): Flux<Lunch> {
        return lunchRepository.streamAllBy()
    }
}

package com.zuehlke.camp.zlunch.services

import com.zuehlke.camp.zlunch.entity.Lunch
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class LunchService(val lunchRepository: LunchRepository) {
    fun findAll(): Flux<Lunch> {
        return lunchRepository.findAll()
    }

    fun steamAll(): Flux<Lunch> {
        return lunchRepository.streamAllBy()
    }
}
package com.zuehlke.camp.zlunch.services

import com.zuehlke.camp.zlunch.entity.*
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import reactor.core.publisher.Flux

interface LunchRepository : ReactiveMongoRepository<Lunch, String>

interface LunchCreatedEventRepository: ReactiveMongoRepository<LunchCreatedEvent, String> {
    @Tailable
    fun streamAllBy(): Flux<LunchCreatedEvent>

}

interface LocationRepository : ReactiveMongoRepository<Location, String>

interface UserRepository : ReactiveMongoRepository<User, String>

interface ParticipationRepository : ReactiveMongoRepository<Participation, String>

package com.zuehlke.camp.zlunch.services

import com.zuehlke.camp.zlunch.entity.*
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import reactor.core.publisher.Flux
import java.time.LocalDate
import java.time.LocalDateTime

interface LunchRepository : ReactiveMongoRepository<Lunch, String> {
    fun findAllByDateIs(date: LocalDate, sort: Sort) : Flux<Lunch>
}

interface LunchCreatedEventRepository: ReactiveMongoRepository<LunchCreatedEvent, String> {
    @Tailable
    fun streamAllByCreatedIsAfterOrderByCreated(date: LocalDateTime): Flux<LunchCreatedEvent>

}

interface LocationRepository : ReactiveMongoRepository<Location, String>

interface UserRepository : ReactiveMongoRepository<User, String>

interface ParticipationRepository : ReactiveMongoRepository<Participation, String> {
    fun findAllByLunchId(id: String): Flux<Participation>
}

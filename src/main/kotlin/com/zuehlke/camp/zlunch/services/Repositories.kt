package com.zuehlke.camp.zlunch.services

import com.zuehlke.camp.zlunch.entity.Location
import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.entity.Participation
import com.zuehlke.camp.zlunch.entity.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface LunchRepository : ReactiveMongoRepository<Lunch, String> {
    fun streamAllBy(): Flux<Lunch>

}

interface LocationRepository : ReactiveMongoRepository<Location, String>

interface UserRepository : ReactiveMongoRepository<User, String>

interface ParticipationRepository : ReactiveMongoRepository<Participation, String>

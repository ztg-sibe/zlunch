package com.zuehlke.camp.zlunch.services

import com.zuehlke.camp.zlunch.entity.Location
import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.entity.Participation
import com.zuehlke.camp.zlunch.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository
import java.time.LocalDate

interface LunchRepository : CrudRepository<Lunch, String> {
    fun findAllByDate(date: LocalDate): Lunch?
}

interface LocationRepository : CrudRepository<Location, String>

interface UserRepository : CrudRepository<User, String>

interface ParticipationRepository : CrudRepository<Participation, String>

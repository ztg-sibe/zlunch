package com.zuehlke.camp.zlunch.services

import com.zuehlke.camp.zlunch.entity.Location
import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.entity.Participation
import com.zuehlke.camp.zlunch.entity.User
import org.springframework.data.repository.CrudRepository
import java.time.LocalDate

interface LunchRepository : CrudRepository<Lunch, Long> {
    fun findAllByDate(date: LocalDate): Lunch?
}

interface LocationRepository : CrudRepository<Location, Long>

interface UserRepository : CrudRepository<User, Long>

interface ParticipationRepository : CrudRepository<Participation, Long>

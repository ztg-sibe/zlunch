package com.zuehlke.camp.zlunch

import com.zuehlke.camp.zlunch.entity.Lunch
import org.springframework.data.repository.CrudRepository
import java.time.LocalDate

interface LunchRepository:  CrudRepository<Lunch, Long> {
    fun findAllByDate(date: LocalDate): Lunch?
}

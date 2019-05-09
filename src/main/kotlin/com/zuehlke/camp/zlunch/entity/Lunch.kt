package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Lunch(
        var name: String,
        var startTime: LocalTime = LocalTime.of(11, 45),
        var date: LocalDate = LocalDate.now(),
        var meetingPoint: String?,
        var location: Location,
        var created: LocalDateTime = LocalDateTime.now(),
        var updated: LocalDateTime = LocalDateTime.now()
) {
    @Id
    var id: String? = null
}

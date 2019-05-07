package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Lunch(
        var name: String,
        var startTime: LocalTime?,
        var date: LocalDate?,
        var meetingPoint: String?,
        var location: Location,
        var created: LocalDateTime = LocalDateTime.now(),
        var updated: LocalDateTime = LocalDateTime.now(),
        @Id var id: Long
)

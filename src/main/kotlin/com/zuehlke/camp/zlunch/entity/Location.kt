package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id
import java.time.LocalDateTime

class Location(
        var name: String,
        var created: LocalDateTime = LocalDateTime.now(),
        @Id var id: Long
)

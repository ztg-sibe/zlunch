package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import java.time.LocalDateTime

class LunchCreatedEvent(
        @DBRef var lunch: Lunch,
        var created: LocalDateTime = LocalDateTime.now(),
        var updated: LocalDateTime = LocalDateTime.now()
) {
    @Id
    var id: String? = null
}

package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import java.time.LocalDateTime

class Participation(
        @DBRef var user: User,
        var lunch: Lunch,
        var note: String? = null,
        var created: LocalDateTime = LocalDateTime.now(),
        var updated: LocalDateTime = LocalDateTime.now()
) {
    @Id
    var id: String? = null
}

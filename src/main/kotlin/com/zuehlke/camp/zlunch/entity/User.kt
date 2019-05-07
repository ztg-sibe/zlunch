package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "user")
class User(
        var name: String,
        var created: LocalDateTime = LocalDateTime.now(),
        var updated: LocalDateTime = LocalDateTime.now()) {

    @Id
    var id: String? = null
}


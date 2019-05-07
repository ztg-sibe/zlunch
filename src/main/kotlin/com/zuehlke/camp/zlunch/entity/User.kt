package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
class User(
        var name: String) {

    @Id
    var id: String? = null
}


package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id

class User(
        var name: String,
        @Id var id: Long
)

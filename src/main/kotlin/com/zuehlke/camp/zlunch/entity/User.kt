package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id

class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id var id: Long? = null)

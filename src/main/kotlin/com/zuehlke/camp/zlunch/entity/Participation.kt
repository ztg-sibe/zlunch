package com.zuehlke.camp.zlunch.entity

import org.springframework.data.annotation.Id

class Participation(
        var user: User,
        var lunch: Lunch,
        var note: String? = null
) {
    @Id
    var id: String? = null
}

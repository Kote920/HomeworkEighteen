package com.example.homeworkeighteen.Users

import com.squareup.moshi.Json

data class User(
    var id: Int,
    var email: String,
    @Json(name = "first_name")
    var firstName: String,
    @Json(name = "last_name")
    var lastName: String,
    var avatar: String
)

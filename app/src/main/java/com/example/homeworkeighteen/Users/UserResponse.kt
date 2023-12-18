package com.example.homeworkeighteen.Users

data class UserResponse(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<User>,
    val support: Support
)

data class Support(
    val url: String,
    val text: String
)
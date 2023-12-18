package com.example.homeworkeighteen.service

import com.example.homeworkeighteen.Users.User
import com.example.homeworkeighteen.Users.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UsersService {
    @GET("users?page=1")
    suspend fun getUsers(): UserResponse
}
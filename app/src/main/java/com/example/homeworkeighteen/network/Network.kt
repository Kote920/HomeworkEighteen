package com.example.homeworksixteen.network

import com.example.homeworkeighteen.service.UsersService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {

    private const val BASE_URL = "https://reqres.in/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun  apiService(): UsersService = retrofit.create(UsersService::class.java)

}

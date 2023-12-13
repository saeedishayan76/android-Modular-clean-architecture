package com.shayan.data.remote

import com.shayan.data.remote.UserDto
import retrofit2.http.GET

interface HomeApiService {

    @GET("todos/")
    suspend fun getUsers(): List<UserDto>
}
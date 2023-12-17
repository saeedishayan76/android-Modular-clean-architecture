package com.shayan.data.remote

import com.shayan.data.remote.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApiService {

    @GET("todos/")
    suspend fun getUsers(): List<UserDto>

    @GET("/todos/{id}")
    suspend fun getUserDetail(@Path("id")id: Int): UserDto
}
package com

import com.model.User
import com.vo.Resource
import kotlinx.coroutines.flow.Flow
interface UserRepo {
    fun getUsers(): Flow<Resource<List<User>>>
    fun getUserDetails(id: Int): Flow<Resource<User>>

    fun loginUser(name: String, pass: String)
}
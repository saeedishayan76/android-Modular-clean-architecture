package com

import com.model.User
import com.vo.Resource
import kotlinx.coroutines.flow.Flow
interface HomeRepo {
    fun getUsers(): Flow<Resource<List<User>>>
}
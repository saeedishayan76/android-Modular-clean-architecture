package com.shayan.data

import com.HomeRepo
import com.model.User
import com.shayan.data.remote.HomeApiService
import com.shayan.data.remote.toUser
import com.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(private val apiService: HomeApiService) :
 HomeRepo{
    override fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(data = apiService.getUsers().map { it.toUser() }))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage?: "error in get users"))
        }
    }
}
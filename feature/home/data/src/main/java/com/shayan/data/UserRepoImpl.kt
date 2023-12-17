package com.shayan.data

import android.util.Log
import com.UserRepo
import com.model.User
import com.shayan.data.remote.HomeApiService
import com.shayan.data.remote.toUser
import com.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepoImpl(private val apiService: HomeApiService) :
 UserRepo{
    override fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(data = apiService.getUsers().map { it.toUser() }))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage?: "error in get users"))
        }
    }

    override fun getUserDetails(id: Int): Flow<Resource<User>> = flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(data = apiService.getUserDetail(id).toUser()))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage?: "error in get user"))
        }
    }

    override fun loginUser(name: String, pass: String) {
        Log.i("TAG", "loginUser: user $name  $pass")
    }
}
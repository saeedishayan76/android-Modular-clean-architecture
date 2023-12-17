package com.usecase

import com.UserRepo
import javax.inject.Inject

class UsersUseCase @Inject constructor(private val userRepo: UserRepo) {

    operator fun invoke() = userRepo.getUsers()
    fun getUser(id: Int) = userRepo.getUserDetails(id)

    fun loginUser(name: String, pass: String) = userRepo.loginUser(name, pass)

}
package com.usecase

import com.HomeRepo
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val homeRepo: HomeRepo) {

    operator fun invoke() = homeRepo.getUsers()
}
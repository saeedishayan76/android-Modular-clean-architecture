package com.shayan.data.remote

import com.model.User

data class UserDto(
    val userId: Int,
    val id: Int,
    val title: String
)

fun UserDto.toUser(): User {
    return User(userId, id, title)
}

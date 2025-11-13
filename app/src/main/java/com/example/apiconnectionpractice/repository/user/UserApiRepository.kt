package com.example.apiconnectionpractice.repository.user

import com.example.apiconnectionpractice.data.model.user.UsersModel

interface UserApiRepository {
    suspend fun getAllUsers(): UsersModel
}
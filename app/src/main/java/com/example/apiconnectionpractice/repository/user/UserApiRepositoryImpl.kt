package com.example.apiconnectionpractice.repository.user

import com.example.apiconnectionpractice.data.model.user.UsersModel
import com.example.apiconnectionpractice.data.network.user.UserApiEndpoints
import javax.inject.Inject

class UserApiRepositoryImpl @Inject constructor(
    private val userApiEndpoints: UserApiEndpoints
) : UserApiRepository {
    override suspend fun getAllUsers(): UsersModel {
        val response = userApiEndpoints.getAllUsers()
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Data is null")
        } else {
            throw Exception("API call failed")
        }
    }

}
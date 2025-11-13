package com.example.apiconnectionpractice.repository

import com.example.apiconnectionpractice.data.model.user.UsersModel
import com.example.apiconnectionpractice.data.network.ApiEndpoints
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiEndpoints: ApiEndpoints
) : ApiRepository {
    override suspend fun getAllUsers(): UsersModel {
        val response = apiEndpoints.getAllUsers()
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Data is null")
        } else {
            throw Exception("API call failed")
        }
    }

}
package com.example.apiconnectionpractice.repository

import com.example.apiconnectionpractice.data.model.user.UsersModel


interface ApiRepository {
    suspend fun getAllUsers(): UsersModel
}
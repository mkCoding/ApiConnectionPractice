package com.example.apiconnectionpractice.data.network

import com.example.apiconnectionpractice.data.model.user.UsersModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiEndpoints {

    //method for making call to api endpoint
    @GET(ApiDetails.ENDPOINT_USERS)
    suspend fun getAllUsers(): Response<UsersModel>
}
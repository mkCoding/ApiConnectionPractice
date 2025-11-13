package com.example.apiconnectionpractice.data.network.user

import com.example.apiconnectionpractice.data.model.user.UsersModel
import retrofit2.Response
import retrofit2.http.GET


interface UserApiEndpoints {

    //method for making call to api endpoint
    @GET(UserApiDetails.ENDPOINT_USERS)
    suspend fun getAllUsers(): Response<UsersModel>
}
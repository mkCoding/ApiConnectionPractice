package com.example.apiconnectionpractice.data.network.products

import com.example.apiconnectionpractice.data.model.products.Products
import com.example.apiconnectionpractice.data.model.products.ProductsItemModel
import com.example.apiconnectionpractice.data.model.user.UsersModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiEndpoints{
    @GET(ProductApiDetails.ENDPOINT_PRODUCTS)
    suspend fun getAllProducts(): Response<Products>
}
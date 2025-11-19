package com.example.apiconnectionpractice.repository.product

import com.example.apiconnectionpractice.data.model.products.Products
import com.example.apiconnectionpractice.data.model.products.ProductsItemModel
import com.example.apiconnectionpractice.data.network.products.ProductApiEndpoints
import javax.inject.Inject

class ProductApiRepositoryImpl @Inject constructor(
    private val productApiEndpoints: ProductApiEndpoints
): ProductApiRepository{
    override suspend fun getAllProducts(): List<ProductsItemModel> {
        val response = productApiEndpoints.getAllProducts()
        if(response.isSuccessful){
            return response.body() ?: emptyList()
        }else{
            throw Exception("API call failed: ${response.code()}")        }
    }

}
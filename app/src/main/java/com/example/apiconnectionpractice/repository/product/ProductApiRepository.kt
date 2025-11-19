package com.example.apiconnectionpractice.repository.product

import com.example.apiconnectionpractice.data.model.products.Products
import com.example.apiconnectionpractice.data.model.products.ProductsItemModel

interface ProductApiRepository{
    suspend fun getAllProducts(): List<ProductsItemModel>
}
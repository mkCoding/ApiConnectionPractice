package com.example.apiconnectionpractice.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apiconnectionpractice.data.model.products.Products
import com.example.apiconnectionpractice.data.model.products.ProductsItemModel
import com.example.apiconnectionpractice.data.model.user.UsersModel
import com.example.apiconnectionpractice.repository.product.ProductApiRepository
import com.example.apiconnectionpractice.repository.user.UserApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    val userApiRepository: UserApiRepository,
    val productApiRepository: ProductApiRepository
) : ViewModel() {    // Define the StateFlow to hold the user data

    private val _userData = MutableStateFlow<UsersModel?>(null)
    val userData: StateFlow<UsersModel?> = _userData

    private val _productData = MutableStateFlow<List<ProductsItemModel>>(emptyList())
    val productData: StateFlow<List<ProductsItemModel>> = _productData

    init {
        fetchUserData()
        fetchProductData()
    }

    private fun fetchProductData() {
        viewModelScope.launch {
            try{
                val productData = productApiRepository.getAllProducts()
               _productData.value = productData
            }catch (e:Exception){
                // Handle the error appropriately
            }
        }
    }

    // Fetch data from the repository and update the StateFlow
    private fun fetchUserData() {
        viewModelScope.launch {
            try {
                val data = userApiRepository.getAllUsers() // Assuming this returns a list of users
                _userData.value = data
            } catch (e: Exception) {
                // Handle the error appropriately
            }
        }
    }
}
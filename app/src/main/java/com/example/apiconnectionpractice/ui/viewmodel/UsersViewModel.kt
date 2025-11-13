package com.example.apiconnectionpractice.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiconnectionpractice.data.model.user.UsersModel
import com.example.apiconnectionpractice.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(val apiRepository: ApiRepository) : ViewModel() {    // Define the StateFlow to hold the user data
    private val _userData = MutableStateFlow<UsersModel?>(null)
    val userData: StateFlow<UsersModel?> = _userData

    init {
        fetchData()
    }

    // Fetch data from the repository and update the StateFlow
    private fun fetchData() {
        viewModelScope.launch {
            try {
                val data = apiRepository.getAllUsers() // Assuming this returns a list of users
                _userData.value = data
            } catch (e: Exception) {
                // Handle the error appropriately
            }
        }
    }
}
package com.example.apiconnectionpractice.utils

// out T represents type of successful data returned
sealed class ResultState<out T> {
    object Loading:ResultState<Nothing>()
    data class Success<out T>(val data:T): ResultState<T>()
    data class Error(val message:String): ResultState<Nothing>()
}
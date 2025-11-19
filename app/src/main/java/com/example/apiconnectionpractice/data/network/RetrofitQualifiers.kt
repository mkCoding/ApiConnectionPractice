package com.example.apiconnectionpractice.data.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserOkHttp

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultOkHttp


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ProductRetrofit
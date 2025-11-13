package com.example.apiconnectionpractice.di

import com.example.apiconnectionpractice.repository.user.UserApiRepository
import com.example.apiconnectionpractice.repository.user.UserApiRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindApiRepository(
        userApiRepositoryImpl: UserApiRepositoryImpl
    ): UserApiRepository


    // if there are any more apis you plan on adding in future add below
}
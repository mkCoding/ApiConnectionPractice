package com.example.apiconnectionpractice.data.network.products

import com.example.apiconnectionpractice.data.network.DefaultOkHttp
import com.example.apiconnectionpractice.data.network.ProductRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductApiModule {

    // Provide Retrofit for Product API
    @ProductRetrofit
    @Provides
    @Singleton
    fun provideProductRetrofit(
        @DefaultOkHttp okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ProductApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provide the API endpoints
    @Provides
    @Singleton
    fun provideProductApiEndpoints(
        @ProductRetrofit retrofit: Retrofit
    ): ProductApiEndpoints {
        return retrofit.create(ProductApiEndpoints::class.java)
    }
}

package com.example.apiconnectionpractice.data.network.user


import com.example.apiconnectionpractice.data.network.UserOkHttp
import com.example.apiconnectionpractice.data.network.UserRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserApiModule {

    private const val API_KEY = "reqres-free-v1"

    // Provide the OkHttpClient for User API
    @UserOkHttp
    @Provides
    @Singleton
    fun provideUserOkHttpClient(): OkHttpClient {
        val authInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("x-api-key", API_KEY)
                .build()
            chain.proceed(request)
        }

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(logging)
            .build()
    }

    // Provide Retrofit for User API
    @UserRetrofit
    @Provides
    @Singleton
    fun provideUserRetrofit(
        @UserOkHttp okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(UserApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provide the API endpoints
    @Provides
    @Singleton
    fun provideUserApiEndpoints(
        @UserRetrofit retrofit: Retrofit
    ): UserApiEndpoints {
        return retrofit.create(UserApiEndpoints::class.java)
    }
}

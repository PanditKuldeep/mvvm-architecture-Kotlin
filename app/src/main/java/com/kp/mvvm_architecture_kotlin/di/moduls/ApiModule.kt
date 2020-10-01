package com.kp.mvvm_architecture_kotlin.di.moduls

import com.kp.mvvm_architecture_kotlin.network.NetworkAPIService
import com.kp.mvvm_architecture_kotlin.network.NetworkConnectionInterceptor
import com.kp.mvvm_architecture_kotlin.network.NetworkURL
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClients = OkHttpClient.Builder().apply {
            addInterceptor(logging)
            // addInterceptor(MyInterceptor())
            addInterceptor(NetworkConnectionInterceptor())
            connectTimeout(NetworkURL.REQUEST_TIMEOUT, TimeUnit.MINUTES)
            readTimeout(NetworkURL.REQUEST_TIMEOUT, TimeUnit.MINUTES)
            writeTimeout(NetworkURL.REQUEST_TIMEOUT, TimeUnit.MINUTES)
        }

        return Retrofit.Builder()
            .baseUrl(NetworkURL.NETWORK_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClients.build())
            .build()
    }

    class MyInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")

            val request = requestBuilder.build()
            return chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideNetworkAPIService(retrofit: Retrofit) = retrofit.create(NetworkAPIService::class.java)
}
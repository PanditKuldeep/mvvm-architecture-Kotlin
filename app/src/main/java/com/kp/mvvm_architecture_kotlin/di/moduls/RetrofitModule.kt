package com.kp.mvvm_architecture_kotlin.di.moduls

import com.kp.mvvm_architecture_kotlin.network.NetworkConnectionInterceptor
import com.kp.mvvm_architecture_kotlin.network.NetworkURL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor)
            .addInterceptor(NetworkConnectionInterceptor())
            .connectTimeout(NetworkURL.REQUEST_TIMEOUT, TimeUnit.MINUTES).build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level= HttpLoggingInterceptor.Level.BODY
        }
    }
}
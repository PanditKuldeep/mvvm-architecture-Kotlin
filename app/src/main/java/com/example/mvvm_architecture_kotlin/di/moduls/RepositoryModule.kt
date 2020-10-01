package com.example.mvvm_architecture_kotlin.di.moduls

import com.example.mvvm_architecture_kotlin.home.HomeRepository
import com.example.mvvm_architecture_kotlin.login.LoginRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideLoginRepository() = LoginRepository()

    @Provides
    @Singleton
    fun provideHomeRepository() = HomeRepository()
}
package com.kuldeep.mvvm_architecture_kotlin.di.comonent

import com.kuldeep.mvvm_architecture_kotlin.di.moduls.ApiModule
import com.kuldeep.mvvm_architecture_kotlin.di.moduls.RetrofitModule
import com.kuldeep.mvvm_architecture_kotlin.home.HomeRepository
import com.kuldeep.mvvm_architecture_kotlin.login.LoginRepository
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RetrofitModule::class, ApiModule::class],dependencies = [AppComponent::class])
interface RepositoryComponent {
    fun inject(loginRepository: LoginRepository)
    fun inject(homeRepository: HomeRepository)
}
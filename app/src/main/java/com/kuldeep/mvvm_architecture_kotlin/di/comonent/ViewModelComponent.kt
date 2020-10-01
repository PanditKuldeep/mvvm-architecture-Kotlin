package com.kuldeep.mvvm_architecture_kotlin.di.comonent

import com.kuldeep.mvvm_architecture_kotlin.di.moduls.RepositoryModule
import com.kuldeep.mvvm_architecture_kotlin.home.HomeViewModel
import com.kuldeep.mvvm_architecture_kotlin.login.LoginViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RepositoryModule::class],dependencies = [AppComponent::class])
interface ViewModelComponent {
    fun inject(loginViewModel: LoginViewModel)
    fun inject(homeViewModel: HomeViewModel)
}
package com.kp.mvvm_architecture_kotlin.di.comonent

import com.kp.mvvm_architecture_kotlin.di.moduls.RepositoryModule
import com.kp.mvvm_architecture_kotlin.home.HomeViewModel
import com.kp.mvvm_architecture_kotlin.login.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class],dependencies = [AppComponent::class])
interface ViewModelComponent {
    fun inject(loginViewModel: LoginViewModel)
    fun inject(homeViewModel: HomeViewModel)
}
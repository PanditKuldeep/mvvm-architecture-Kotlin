package com.example.mvvm_architecture_kotlin.login

import com.example.mvvm_architecture_kotlin.di.comonent.DaggerRepositoryComponent
import com.example.mvvm_architecture_kotlin.global.App
import com.example.mvvm_architecture_kotlin.network.NetworkAPIService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository {

    init {
        DaggerRepositoryComponent.builder().appComponent(App.component).build().inject(this)
    }

    fun checkUser(password: String) = flow<Boolean> {
        if (password.equals("Admin", ignoreCase = true)) {
            emit(true)
        } else {
            emit(false)
        }
    }

}
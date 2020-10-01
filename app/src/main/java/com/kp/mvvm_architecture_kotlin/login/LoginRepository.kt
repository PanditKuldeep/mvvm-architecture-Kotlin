package com.kp.mvvm_architecture_kotlin.login

import com.kp.mvvm_architecture_kotlin.di.comonent.DaggerRepositoryComponent
import com.kp.mvvm_architecture_kotlin.global.App
import kotlinx.coroutines.flow.flow

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
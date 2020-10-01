package com.kp.mvvm_architecture_kotlin.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.mvvm_architecture_kotlin.di.comonent.DaggerViewModelComponent
import com.kp.mvvm_architecture_kotlin.global.App
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel : ViewModel() {
    @Inject
    lateinit var loginRepository: LoginRepository

    init {
        DaggerViewModelComponent.builder().appComponent(App.component).build().inject(this)
    }

    fun getUser(password: String): LiveData<Boolean> {
        val result = MutableLiveData<Boolean>()
        viewModelScope.launch {
            loginRepository.checkUser(password).collect {
                result.value = it
            }
        }
        return result
    }

}
package com.kp.mvvm_architecture_kotlin.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.mvvm_architecture_kotlin.di.comonent.DaggerViewModelComponent
import com.kp.mvvm_architecture_kotlin.global.App
import com.kp.mvvm_architecture_kotlin.utils.livedata_wrapper.StateLiveData
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel  : ViewModel() {
    @Inject
    lateinit var homeRepository: HomeRepository

    init {
        DaggerViewModelComponent.builder().appComponent(App.component).build().inject(this)
    }

    fun getDetails(): StateLiveData<List<Response>> {
        val response = StateLiveData<List<Response>>()
        response.postLoading()
        viewModelScope.launch {
            try {
                homeRepository.getResponse().collect {result->
                    if (result != null) {
                        response.postSuccess(result.data)
                    }
                }
            } catch (e: Exception) {
                response.postError(Throwable(e.message))
                e.printStackTrace()
            }
        }
        return response
    }
}
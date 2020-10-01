package com.kp.mvvm_architecture_kotlin.home

import com.kp.mvvm_architecture_kotlin.di.comonent.DaggerRepositoryComponent
import com.kp.mvvm_architecture_kotlin.global.App
import com.kp.mvvm_architecture_kotlin.network.NetworkAPIService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository {
    @Inject
    lateinit var networkAPIService: NetworkAPIService


    init {
        DaggerRepositoryComponent.builder().appComponent(App.component).build().inject(this)
    }

    fun getResponse() = flow {
        networkAPIService.getDataResponse().runCatching {
            try {
                emit(body())
            } catch (e: Exception) {
                e.printStackTrace()
                emit(null)
            }
        }
    }
}
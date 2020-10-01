package com.kp.mvvm_architecture_kotlin.network

import com.kp.mvvm_architecture_kotlin.global.App
import com.kp.mvvm_architecture_kotlin.utils.Utils
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        if(!Utils.isConnectivityAvailable(App.component.app())){
            throw NoConnectivityException()
        }

        return chain.proceed(chain.request().newBuilder().build())

    }
}
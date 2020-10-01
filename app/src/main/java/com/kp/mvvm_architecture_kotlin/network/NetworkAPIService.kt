package com.kp.mvvm_architecture_kotlin.network

import androidx.annotation.WorkerThread
import com.kp.mvvm_architecture_kotlin.home.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface NetworkAPIService {

    @GET("v1/employees")
    @WorkerThread
    suspend fun getDataResponse() : Response<HomeResponse?>

}
package com.kp.mvvm_architecture_kotlin.utils

import android.content.Context
import android.net.ConnectivityManager


object Utils {

    fun isConnectivityAvailable(context: Context) : Boolean {
        val connectivityManager= context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=connectivityManager.activeNetworkInfo
        return  networkInfo!=null && networkInfo.isConnected
    }
}
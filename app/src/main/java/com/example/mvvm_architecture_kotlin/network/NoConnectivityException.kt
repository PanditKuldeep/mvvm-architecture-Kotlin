package com.example.mvvm_architecture_kotlin.network

import java.io.IOException

class NoConnectivityException: IOException() {

    override val message: String?
        get() = "No Internet Connection found.. Please connect"

}
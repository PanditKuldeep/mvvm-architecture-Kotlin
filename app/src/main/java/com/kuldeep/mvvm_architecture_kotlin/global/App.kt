package com.kuldeep.mvvm_architecture_kotlin.global

import androidx.multidex.MultiDexApplication
import com.kuldeep.mvvm_architecture_kotlin.di.comonent.AppComponent
import com.kuldeep.mvvm_architecture_kotlin.di.comonent.DaggerAppComponent
import com.kuldeep.mvvm_architecture_kotlin.di.moduls.AppModule

class App : MultiDexApplication() {
    companion object {
        lateinit var component: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
package com.kp.mvvm_architecture_kotlin.di.comonent

import com.kp.mvvm_architecture_kotlin.di.moduls.AppModule
import com.kp.mvvm_architecture_kotlin.global.App
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun app(): App
}
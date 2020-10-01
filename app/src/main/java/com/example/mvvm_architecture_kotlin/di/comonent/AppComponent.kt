package com.example.mvvm_architecture_kotlin.di.comonent

import com.example.mvvm_architecture_kotlin.di.moduls.AppModule
import com.example.mvvm_architecture_kotlin.global.App
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun app(): App
}
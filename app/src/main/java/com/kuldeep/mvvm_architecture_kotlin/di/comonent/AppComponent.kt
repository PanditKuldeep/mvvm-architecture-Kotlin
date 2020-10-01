package com.kuldeep.mvvm_architecture_kotlin.di.comonent

import com.kuldeep.mvvm_architecture_kotlin.di.moduls.AppModule
import com.kuldeep.mvvm_architecture_kotlin.global.App
import dagger.Component


@Component(modules = [AppModule::class])
interface AppComponent {
    fun app(): App
}
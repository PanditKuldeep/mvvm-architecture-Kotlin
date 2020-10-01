package com.kuldeep.mvvm_architecture_kotlin.di.moduls

import com.kuldeep.mvvm_architecture_kotlin.global.App
import dagger.Module
import dagger.Provides


@Module
class AppModule constructor(private val app: App){
    @Provides
    fun provideApp(): App = app
}
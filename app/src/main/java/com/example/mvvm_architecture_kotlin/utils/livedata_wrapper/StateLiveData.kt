package com.example.mvvm_architecture_kotlin.utils.livedata_wrapper

import androidx.lifecycle.MutableLiveData

class StateLiveData<T> : MutableLiveData<StateData<T>>() {

    fun postLoading() {
        value = StateData<T>().loading()
    }

    fun postError(throwable: Throwable) {
        value = StateData<T>().error(throwable)
    }

    fun postSuccess(data: T) {
        value = StateData<T>().success(data)
    }

    fun postComplete() {
        value = StateData<T>().complete()
    }
}
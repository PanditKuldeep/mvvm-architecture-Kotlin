package com.kp.mvvm_architecture_kotlin.utils.livedata_wrapper

enum class DataStatus {
    CREATED, SUCCESS, ERROR, LOADING, COMPLETE
}

class StateData<T> {
    var status: DataStatus = DataStatus.CREATED
    var data: T? = null
    var error: Throwable? = null

    fun loading(): StateData<T>? {
        status = DataStatus.LOADING
        data = null
        error = null
        return this
    }

    fun success(mData: T): StateData<T>? {
        status = DataStatus.SUCCESS
        data = mData
        error = null
        return this
    }

    fun error(mError: Throwable): StateData<T>? {
        status = DataStatus.ERROR
        data = null
        error = mError
        return this
    }

    fun complete(): StateData<T>? {
        status = DataStatus.COMPLETE
        return this
    }
}
package com.cirodev.boldweatherapi.viewmodel

import com.cirodev.boldweatherapi.core.generic.Failure

sealed interface DataResult<out T> {
    object OnLoading : DataResult<Nothing>
    data class OnSuccess<T>(val data: T) : DataResult<T>
    data class OnFailed(val failure: Failure? = null) : DataResult<Nothing>
}

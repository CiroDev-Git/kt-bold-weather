package com.cirodev.boldweatherapi.core.generic

sealed class Failure {
    data object NetworkError : Failure()
    data object UnknownError : Failure()
}

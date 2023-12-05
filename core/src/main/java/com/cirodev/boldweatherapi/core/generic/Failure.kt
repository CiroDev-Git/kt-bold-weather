package com.cirodev.boldweatherapi.core.generic

sealed class Failure {
    object NetworkError : Failure()
    object UnknownError : Failure()
}

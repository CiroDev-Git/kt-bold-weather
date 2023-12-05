package com.cirodev.boldweatherapi.data.api

import retrofit2.HttpException
import retrofit2.Response

const val API_RESULT_TAG = "ApiResult"

sealed class ApiResult<T : Any> {
    class Success<T : Any>(val data: T) : ApiResult<T>()
    class Error<T : Any>(val code: Int, val message: String?) : ApiResult<T>()
    class Exception<T : Any>(val e: Throwable) : ApiResult<T>()
}

suspend fun <T : Any> handleRequest(
    execute: suspend () -> Response<T>
): ApiResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            ApiResult.Success(body)
        } else {
            ApiResult.Error(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        ApiResult.Error(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        ApiResult.Exception(e)
    }
}
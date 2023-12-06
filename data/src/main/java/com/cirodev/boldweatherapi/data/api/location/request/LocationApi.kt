package com.cirodev.boldweatherapi.data.api.location.request

import com.cirodev.boldweatherapi.data.api.location.response.ForecastInfoDto
import com.cirodev.boldweatherapi.data.api.location.response.LocationDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {

    @GET("search.json")
    suspend fun searchLocations(
        @Query("q") query: String
    ): Response<List<LocationDto>>

    @GET("forecast.json")
    suspend fun forecastLocation(
        @Query("q") name: String,
        @Query("days") forecastDays: Int = 2
    ): Response<ForecastInfoDto>

}
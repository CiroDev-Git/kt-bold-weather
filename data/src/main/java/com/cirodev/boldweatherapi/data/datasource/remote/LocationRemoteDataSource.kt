package com.cirodev.boldweatherapi.data.datasource.remote

import com.cirodev.boldweatherapi.data.api.ApiResult
import com.cirodev.boldweatherapi.data.api.handleRequest
import com.cirodev.boldweatherapi.data.api.location.request.LocationApi
import com.cirodev.boldweatherapi.data.api.location.response.ForecastInfoDto
import com.cirodev.boldweatherapi.data.api.location.response.LocationDto

interface LocationRemoteDataSource {
    suspend fun searchLocations(query: String): ApiResult<List<LocationDto>>
    suspend fun getForecastByLocation(name: String): ApiResult<ForecastInfoDto>
}

class LocationRemoteDataSourceImpl(
    private val api: LocationApi
) : LocationRemoteDataSource {

    override suspend fun searchLocations(query: String): ApiResult<List<LocationDto>> =
        handleRequest { api.searchLocations(query) }

    override suspend fun getForecastByLocation(name: String): ApiResult<ForecastInfoDto> =
        handleRequest { api.forecastLocation(name) }

}
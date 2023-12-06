package com.cirodev.boldweatherapi.data.api.location.response

import com.cirodev.boldweatherapi.domain.model.ForecastInfo

data class ForecastInfoDto(
    val location: LocationDto,
    val current: CurrentDto,
    val forecast: ForecastDto
)

fun ForecastInfoDto.mapToDomain() = ForecastInfo(
    location = location.mapToDomain(),
    current = current.mapToDomain(),
    forecast = forecast.mapToDomain()
)

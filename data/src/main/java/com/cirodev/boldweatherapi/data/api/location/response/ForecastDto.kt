package com.cirodev.boldweatherapi.data.api.location.response

import com.cirodev.boldweatherapi.domain.model.Forecast
import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday")
    val forecastDays: List<ForecastDayDto>
)

fun ForecastDto.mapToDomain() = Forecast(
    forecastDays.map { it.mapToDomain() }
)

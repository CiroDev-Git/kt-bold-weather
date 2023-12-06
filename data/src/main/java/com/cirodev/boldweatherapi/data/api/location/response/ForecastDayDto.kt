package com.cirodev.boldweatherapi.data.api.location.response

import com.cirodev.boldweatherapi.domain.model.ForecastDay

data class ForecastDayDto(
    val date: String,
    val day: DayDto
)

fun ForecastDayDto.mapToDomain() = ForecastDay(
    date, day.mapToDomain()
)

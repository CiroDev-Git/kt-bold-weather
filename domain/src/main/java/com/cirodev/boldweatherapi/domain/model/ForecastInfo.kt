package com.cirodev.boldweatherapi.domain.model

data class ForecastInfo(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)
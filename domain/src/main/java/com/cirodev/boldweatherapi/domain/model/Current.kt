package com.cirodev.boldweatherapi.domain.model

data class Current(
    val lastUpdated: String,
    val tempC: Double,
    val condition: Condition,
    val windKph: Double,
    val windDir: String,
    val precipMm: Double,
    val humidity: Double,
    val feelsLikeC: Double,
    val uv: Double
)

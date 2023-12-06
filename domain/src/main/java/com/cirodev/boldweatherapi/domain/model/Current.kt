package com.cirodev.boldweatherapi.domain.model

data class Current(
    val lastUpdated: String,
    val tempC: Int,
    val condition: Condition,
    val windKph: Double,
    val windDir: String,
    val precipMm: Double,
    val humidity: Int,
    val feelsLikeC: Int,
    val uv: Int
)

package com.cirodev.boldweatherapi.domain.model

data class Day(
    val maxTempC: Double,
    val minTempC: Double,
    val avgTempC: Double,
    val avgHumidity: Double,
    val dailyChanceOfRain: Double,
    val condition: Condition,
    val uv: Double
)

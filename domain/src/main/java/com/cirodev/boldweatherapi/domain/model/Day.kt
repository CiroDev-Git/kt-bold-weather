package com.cirodev.boldweatherapi.domain.model

data class Day(
    val maxTempC: Int,
    val minTempC: Double,
    val avgTempC: Double,
    val avgHumidity: Int,
    val dailyChanceOfRain: Int,
    val condition: Condition,
    val uv: Int
)

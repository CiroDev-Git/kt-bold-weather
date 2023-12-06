package com.cirodev.boldweatherapi.data.api.location.response

import com.cirodev.boldweatherapi.domain.model.Day
import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("maxtemp_c")
    val maxTempC: Int,
    @SerializedName("mintemp_c")
    val minTempC: Double,
    @SerializedName("avgtemp_c")
    val avgTempC: Double,
    @SerializedName("avghumidity")
    val avgHumidity: Int,
    @SerializedName("daily_chance_of_rain")
    val dailyChanceOfRain: Int,
    val condition: ConditionDto,
    val uv: Int
)

fun DayDto.mapToDomain() = Day(
    maxTempC, minTempC, avgTempC, avgHumidity, dailyChanceOfRain, condition.mapToDomain(), uv
)

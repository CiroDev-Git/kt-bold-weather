package com.cirodev.boldweatherapi.data.api.location.response

import com.cirodev.boldweatherapi.domain.model.Current
import com.google.gson.annotations.SerializedName

data class CurrentDto(
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("temp_c")
    val tempC: Int,
    val condition: ConditionDto,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("precip_mm")
    val precipMm: Double,
    val humidity: Int,
    @SerializedName("feelslike_c")
    val feelsLikeC: Int,
    val uv: Int
)

fun CurrentDto.mapToDomain() = Current(
    lastUpdated,
    tempC,
    condition.mapToDomain(),
    windKph,
    windDir,
    precipMm,
    humidity,
    feelsLikeC,
    uv
)

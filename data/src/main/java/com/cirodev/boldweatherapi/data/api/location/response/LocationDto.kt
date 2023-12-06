package com.cirodev.boldweatherapi.data.api.location.response

import com.cirodev.boldweatherapi.domain.model.Location
import com.google.gson.annotations.SerializedName

data class LocationDto(
    val id: Long?,
    val name: String,
    val region: String,
    val country: String,
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lon")
    val longitude: Double,
    val url: String?,
    @SerializedName("tz_id")
    val timezone: String?,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int?,
    @SerializedName("localtime")
    val localtime: String?
)

fun LocationDto.mapToDomain() = Location(
    id, name, region, country, latitude, longitude, timezone
)

fun List<LocationDto>.toDomainList() = this.map { it.mapToDomain() }

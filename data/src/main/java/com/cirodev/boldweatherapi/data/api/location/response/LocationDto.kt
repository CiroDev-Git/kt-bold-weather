package com.cirodev.boldweatherapi.data.api.location.response

import com.cirodev.boldweatherapi.domain.model.Location
import com.google.gson.annotations.SerializedName

data class LocationDto(
    val id: Long,
    val name: String,
    val region: String,
    val country: String,
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lon")
    val longitude: Double,
    val url: String
)

fun LocationDto.mapToDomain() = Location(
    id, name, region, country, latitude, longitude
)

fun List<LocationDto>.toDomainList() = this.map { it.mapToDomain() }

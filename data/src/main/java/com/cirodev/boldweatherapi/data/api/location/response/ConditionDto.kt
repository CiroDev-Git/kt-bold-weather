package com.cirodev.boldweatherapi.data.api.location.response

import com.cirodev.boldweatherapi.domain.model.Condition

data class ConditionDto(
    val text: String,
    val icon: String,
    val code: Int
)

fun ConditionDto.mapToDomain() = Condition(
    text, icon, code
)

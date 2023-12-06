package com.cirodev.boldweatherapi.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cirodev.boldweatherapi.R

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconComponent(icon = R.drawable.baseline_water_drop_24)
        LogoComponent(icon = R.drawable.weather_error)
        IconComponent(icon = R.drawable.baseline_wind_power_24)
    }
}
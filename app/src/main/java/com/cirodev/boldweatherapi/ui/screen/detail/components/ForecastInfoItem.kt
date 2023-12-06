package com.cirodev.boldweatherapi.ui.screen.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cirodev.boldweatherapi.R
import com.cirodev.boldweatherapi.domain.model.ForecastInfo

@Composable
fun ForecastInfoItem(
    forecastInfo: ForecastInfo
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AsyncImage(
                model = forecastInfo.current.condition.icon,
                contentDescription = forecastInfo.current.condition.text,
                modifier = Modifier.width(80.dp),
                placeholder = painterResource(id = R.drawable.weather_forecast),
                error = painterResource(id = R.drawable.weather_error)
            )
        }
        item {
            LocationOverview(forecastInfo)
        }
        item {
            CurrentOverview(forecastInfo)
        }
        item {
            Text(
                text = stringResource(R.string.forecast_info),
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 24.dp)
            )
        }
        forecastInfo.forecast.forecastDays.forEach {
            item {
                DayInfoItem(it)
            }
        }
    }
}

@Composable
private fun LocationOverview(forecastInfo: ForecastInfo) {
    Column(
        modifier = Modifier.padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = forecastInfo.current.condition.text,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        Text(
            text = "${forecastInfo.current.tempC}${stringResource(R.string.celcius)}",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "${forecastInfo.location.name}\n${forecastInfo.location.country}",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "${stringResource(R.string.last_updated)}: ${forecastInfo.current.lastUpdated}",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 24.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun CurrentOverview(forecastInfo: ForecastInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
    ) {
        Row(Modifier.padding(16.dp)) {
            CurrentInfoItem(
                R.drawable.baseline_light_mode_24,
                stringResource(R.string.uv_index),
                forecastInfo.current.uv.toString(),
                Modifier.weight(1f)
            )
            CurrentInfoItem(
                R.drawable.baseline_water_drop_24,
                stringResource(R.string.humidity),
                forecastInfo.current.humidity.toString(),
                Modifier.weight(1f)
            )
        }
        Row(Modifier.padding(16.dp)) {
            CurrentInfoItem(
                R.drawable.baseline_directions_24,
                stringResource(R.string.wind_direction),
                forecastInfo.current.windDir,
                Modifier.weight(1f)
            )
            CurrentInfoItem(
                R.drawable.baseline_wind_power_24,
                stringResource(R.string.wind_speed),
                "${forecastInfo.current.windKph}${stringResource(R.string.kph)}",
                Modifier.weight(1f)
            )
        }
    }
}
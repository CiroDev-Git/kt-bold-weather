package com.cirodev.boldweatherapi.ui.screen.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cirodev.boldweatherapi.R
import com.cirodev.boldweatherapi.domain.model.ForecastDay

@Composable
fun DayInfoItem(
    forecastDay: ForecastDay
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = forecastDay.day.condition.icon,
            contentDescription = forecastDay.day.condition.text,
            modifier = Modifier
                .padding(end = 8.dp)
                .width(40.dp),
            placeholder = painterResource(id = R.drawable.weather_forecast),
            error = painterResource(id = R.drawable.weather_error)
        )
        Column {
            Text(
                forecastDay.date,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            forecastDay.day.let {
                Row {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "${stringResource(R.string.avg)} ${it.avgTempC}${stringResource(R.string.celcius)}",
                            color = Color.Gray
                        )
                        Text(it.condition.text, color = Color.Gray)
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "${stringResource(R.string.min_temperature)}: ${it.minTempC}${stringResource(R.string.celcius)}",
                            color = Color.Gray
                        )
                        Text(
                            "${stringResource(R.string.max_temperature)}: ${it.maxTempC}${stringResource(R.string.celcius)}",
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}
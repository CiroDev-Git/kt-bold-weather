package com.cirodev.boldweatherapi.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.cirodev.boldweatherapi.ui.component.FailedMessage
import com.cirodev.boldweatherapi.ui.component.LoadingMessage
import com.cirodev.boldweatherapi.ui.screen.detail.components.ForecastInfoItem
import com.cirodev.boldweatherapi.viewmodel.DataResult
import com.cirodev.boldweatherapi.viewmodel.ForecastViewModel

@Composable
fun DetailScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
    locationName: String
) {
    viewModel.getForecastByLocation(locationName)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            when (val state = viewModel.forecastState.collectAsState().value) {
                null,
                is DataResult.OnLoading -> {
                    LoadingMessage(Modifier.align(Alignment.CenterHorizontally))
                }

                is DataResult.OnFailed -> {
                    FailedMessage(Modifier.align(Alignment.CenterHorizontally), state.failure)
                }

                is DataResult.OnSuccess -> {
                    ForecastInfoItem(state.data)
                }
            }
        }
    }
}
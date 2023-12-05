package com.cirodev.boldweatherapi.ui.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.cirodev.boldweatherapi.viewmodel.DataResult
import com.cirodev.boldweatherapi.viewmodel.LocationViewModel

@Composable
fun SearchScreen(
    viewModel: LocationViewModel = hiltViewModel()
) {
    val state = viewModel.locationsState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column (
            modifier = Modifier.padding(it)
        ) {
            when(state.value) {
                is DataResult.OnLoading -> {
                }
                is DataResult.OnFailed -> {
                }
                is DataResult.OnSuccess -> {
                }
                else -> {
                }
            }
        }
    }
}
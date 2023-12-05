package com.cirodev.boldweatherapi.ui.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.cirodev.boldweatherapi.R
import com.cirodev.boldweatherapi.core.generic.Failure
import com.cirodev.boldweatherapi.ui.component.BasicMessage
import com.cirodev.boldweatherapi.ui.component.LoadingMessage
import com.cirodev.boldweatherapi.ui.component.SearchInput
import com.cirodev.boldweatherapi.viewmodel.DataResult
import com.cirodev.boldweatherapi.viewmodel.LocationViewModel

@Composable
fun SearchScreen(
    viewModel: LocationViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column (
            modifier = Modifier.padding(it)
        ) {
            SearchInput { query -> viewModel.searchLocations(query) }
            when(val state = viewModel.locationsState.collectAsState().value) {
                is DataResult.OnLoading -> {
                    LoadingMessage(Modifier.align(Alignment.CenterHorizontally))
                }
                is DataResult.OnFailed -> {
                    val message = when(state.failure) {
                        null,
                        Failure.UnknownError -> stringResource(R.string.something_wrong)
                        Failure.NetworkError -> stringResource(R.string.no_internet_connection)
                    }
                    BasicMessage(Modifier.align(Alignment.CenterHorizontally), message)
                }
                is DataResult.OnSuccess -> {
                }
                else -> {
                    BasicMessage(
                        Modifier.align(Alignment.CenterHorizontally),
                        stringResource(R.string.lets_start)
                    )
                }
            }
        }
    }
}
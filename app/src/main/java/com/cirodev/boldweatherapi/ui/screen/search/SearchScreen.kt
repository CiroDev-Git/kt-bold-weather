package com.cirodev.boldweatherapi.ui.screen.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cirodev.boldweatherapi.R
import com.cirodev.boldweatherapi.ui.component.BasicMessage
import com.cirodev.boldweatherapi.ui.component.FailedMessage
import com.cirodev.boldweatherapi.ui.component.Header
import com.cirodev.boldweatherapi.ui.component.IconComponent
import com.cirodev.boldweatherapi.ui.component.LoadingMessage
import com.cirodev.boldweatherapi.ui.component.SearchInput
import com.cirodev.boldweatherapi.ui.screen.search.components.LocationCardItem
import com.cirodev.boldweatherapi.ui.theme.colorSecondary
import com.cirodev.boldweatherapi.viewmodel.DataResult
import com.cirodev.boldweatherapi.viewmodel.LocationViewModel

@Composable
fun SearchScreen(
    viewModel: LocationViewModel = hiltViewModel(),
    onDetail: (String) -> Unit
) {
    val state = viewModel.locationsState.collectAsState().value
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Header()
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    SearchSection { viewModel.searchLocations(it) }
                }
                when (state) {
                    is DataResult.OnLoading -> {
                        item {
                            LoadingMessage(Modifier.align(Alignment.CenterHorizontally))
                        }
                    }

                    is DataResult.OnFailed -> {
                        item {
                            FailedMessage(
                                Modifier.align(Alignment.CenterHorizontally),
                                state.failure
                            )
                        }
                    }

                    is DataResult.OnSuccess -> {
                        if (state.data.isEmpty()) {
                            item {
                                BasicMessage(
                                    Modifier.align(Alignment.CenterHorizontally),
                                    stringResource(R.string.no_locations_found)
                                )
                            }
                        } else {
                            items(
                                count = state.data.size,
                                key = { state.data[it].id!! },
                                itemContent = {
                                    LocationCardItem(
                                        state.data[it],
                                    ) { location ->
                                        onDetail("${location.name} ${location.region}")
                                    }
                                }
                            )
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}

@Composable
private fun SearchSection(
    onSearch: (String) -> Unit
) {
    val toSearch = rememberSaveable { mutableStateOf("") }
    Text(
        text = stringResource(id = R.string.lets_start),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.W600,
            color = MaterialTheme.colorScheme.onBackground
        ),
        modifier = Modifier.padding(vertical = 30.dp)
    )
    Box(modifier = Modifier.padding(bottom = 30.dp)) {
        SearchInput(toSearch) { onSearch(it) }
        IconComponent(
            icon = R.drawable.baseline_clear_24,
            background = colorSecondary,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(55.dp)
        ) {
            toSearch.value = ""
            onSearch(toSearch.value)
        }
    }
}
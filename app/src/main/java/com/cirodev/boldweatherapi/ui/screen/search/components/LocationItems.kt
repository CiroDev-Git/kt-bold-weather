package com.cirodev.boldweatherapi.ui.screen.search.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cirodev.boldweatherapi.domain.model.Location

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LocationItems(
    locations: List<Location>,
    onLocation: (Location) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            count = locations.size,
            key = { locations[it].id!! },
            itemContent = {
                locations[it].let { location ->
                    LocationCardItem(
                        location,
                        Modifier.animateItemPlacement()
                    ) { onLocation(location) }
                }
            }
        )
    }
}
package com.cirodev.boldweatherapi.ui.screen.search.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cirodev.boldweatherapi.domain.model.Location

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LocationItems(
    locations: List<Location>,
    onLocation: (Location) -> Unit
) {
    LazyRow {
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
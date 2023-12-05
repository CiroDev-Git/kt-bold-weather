package com.cirodev.boldweatherapi.ui.screen.search.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cirodev.boldweatherapi.R
import com.cirodev.boldweatherapi.domain.model.Location
import com.cirodev.boldweatherapi.ui.component.BasicMessage

@Composable
fun SearchSuccess(
    modifier: Modifier,
    locations: List<Location>,
    onLocation: (Location) -> Unit
) {
    if (locations.isEmpty()) {
        BasicMessage(modifier, stringResource(R.string.no_locations_found))
    } else {
        LocationItems(locations, onLocation)
    }
}
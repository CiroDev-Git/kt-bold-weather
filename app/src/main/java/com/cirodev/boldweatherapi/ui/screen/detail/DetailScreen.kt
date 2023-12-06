package com.cirodev.boldweatherapi.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cirodev.boldweatherapi.ui.component.BasicMessage

@Composable
fun DetailScreen(
    locationName: String
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            BasicMessage(
                Modifier.align(Alignment.CenterHorizontally),
                locationName
            )
        }
    }
}
package com.cirodev.boldweatherapi.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cirodev.boldweatherapi.R

@Composable
fun Header(
    onTheme: () -> Unit,
    onLang: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(4.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconComponent(icon = R.drawable.baseline_language_24) {
            onLang()
        }
        LogoComponent(icon = R.drawable.nube)
        IconComponent(icon = R.drawable.baseline_dark_mode_24) {
            onTheme()
        }
    }
}
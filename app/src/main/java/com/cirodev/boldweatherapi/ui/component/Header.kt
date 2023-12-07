package com.cirodev.boldweatherapi.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cirodev.boldweatherapi.R
import com.cirodev.boldweatherapi.ui.theme.LangType

@Composable
fun Header(
    lang: LangType,
    onTheme: () -> Unit,
    onLang: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconComponent(icon = R.drawable.baseline_language_24) {
                onLang()
            }
            Text(
                "${stringResource(R.string.api)}: $lang",
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
            )
        }
        LogoComponent(icon = R.drawable.nube)
        IconComponent(icon = R.drawable.baseline_dark_mode_24) {
            onTheme()
        }
    }
}
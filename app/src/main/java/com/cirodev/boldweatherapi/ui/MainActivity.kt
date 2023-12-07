package com.cirodev.boldweatherapi.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cirodev.boldweatherapi.ui.routing.NavGraph
import com.cirodev.boldweatherapi.ui.theme.AppTheme
import com.cirodev.boldweatherapi.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadAppConfig(isDarkModeOn())
        setContent {
            viewModel.appState?.let {
                AppTheme(theme = it.themeType) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavGraph(
                            onTheme = {
                                viewModel.updateTheme()
                            },
                            onLang = {
                                viewModel.updateLang()
                            }
                        )
                    }
                }
            }
        }
    }

    private fun isDarkModeOn(): Boolean {
        val nightModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES
    }

}
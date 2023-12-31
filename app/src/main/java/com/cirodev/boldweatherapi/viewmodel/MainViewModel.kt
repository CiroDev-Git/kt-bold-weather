package com.cirodev.boldweatherapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirodev.boldweatherapi.SettingsManager
import com.cirodev.boldweatherapi.ui.theme.LangType
import com.cirodev.boldweatherapi.ui.theme.ThemeType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val settingsManager: SettingsManager
) : ViewModel() {

    var appState by mutableStateOf<AppConfig?>(null)

    fun loadAppConfig(darkModeOn: Boolean? = null) {
        viewModelScope.launch {
            if (darkModeOn == true) {
                settingsManager.saveConfig(SettingsManager.THEME_KEY, ThemeType.Dark.toString())
            }
            val lang = settingsManager.getConfig(SettingsManager.LANG_KEY).first()
            val theme = settingsManager.getConfig(SettingsManager.THEME_KEY).first()
            if (lang == null) {
                settingsManager.saveConfig(SettingsManager.LANG_KEY, LangType.ES.toString())
            }
            appState = AppConfig(
                themeType = when (theme) {
                    ThemeType.Light.toString() -> ThemeType.Light
                    ThemeType.Dark.toString() -> ThemeType.Dark
                    else -> ThemeType.Default
                },
                langType = when (lang) {
                    LangType.EN.toString() -> LangType.EN
                    else -> LangType.ES
                }
            )
        }
    }

    fun updateTheme() {
        viewModelScope.launch {
            val theme = settingsManager.getConfig(SettingsManager.THEME_KEY).first()
            if (theme == ThemeType.Dark.toString()) {
                settingsManager.saveConfig(SettingsManager.THEME_KEY, ThemeType.Light.toString())
            } else {
                settingsManager.saveConfig(SettingsManager.THEME_KEY, ThemeType.Dark.toString())
            }
            loadAppConfig()
        }
    }

    fun updateLang() {
        viewModelScope.launch {
            val lang = settingsManager.getConfig(SettingsManager.LANG_KEY).first()
            if (lang == LangType.ES.toString()) {
                settingsManager.saveConfig(SettingsManager.LANG_KEY, LangType.EN.toString())
            } else {
                settingsManager.saveConfig(SettingsManager.LANG_KEY, LangType.ES.toString())
            }
            loadAppConfig()
        }
    }

}
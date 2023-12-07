package com.cirodev.boldweatherapi.viewmodel

import com.cirodev.boldweatherapi.ui.theme.LangType
import com.cirodev.boldweatherapi.ui.theme.ThemeType

data class AppConfig(
    var themeType: ThemeType,
    var langType: LangType
)
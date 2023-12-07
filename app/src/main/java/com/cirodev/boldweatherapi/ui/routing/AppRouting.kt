package com.cirodev.boldweatherapi.ui.routing

import com.cirodev.boldweatherapi.ui.routing.AppRoutesName.DETAIL_SCREEN
import com.cirodev.boldweatherapi.ui.routing.AppRoutesName.SEARCH_SCREEN
import com.cirodev.boldweatherapi.ui.routing.AppRoutesName.SPLASH_SCREEN

object AppRoutesName {
    const val SPLASH_SCREEN = "SPLASH"
    const val SEARCH_SCREEN = "SEARCH"
    const val DETAIL_SCREEN = "DETAIL"
}

sealed class AppRouting(val route: String) {
    object SplashScreen : AppRouting(SPLASH_SCREEN)
    object SearchScreen : AppRouting(SEARCH_SCREEN)
    object DetailScreen : AppRouting(DETAIL_SCREEN)
}

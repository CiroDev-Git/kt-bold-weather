package com.cirodev.boldweatherapi.ui.routing

import com.cirodev.boldweatherapi.ui.routing.AppRoutesName.DETAIL_SCREEN
import com.cirodev.boldweatherapi.ui.routing.AppRoutesName.SEARCH_SCREEN

object AppRoutesName {
    const val SEARCH_SCREEN = "SEARCH"
    const val DETAIL_SCREEN = "DETAIL"
}

sealed class AppRouting(val route: String) {
    object SearchScreen : AppRouting(SEARCH_SCREEN)
    object DetailScreen : AppRouting(DETAIL_SCREEN)
}

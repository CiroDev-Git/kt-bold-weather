package com.cirodev.boldweatherapi.ui.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cirodev.boldweatherapi.ui.screen.detail.DetailScreen
import com.cirodev.boldweatherapi.ui.screen.search.SearchScreen
import com.cirodev.boldweatherapi.ui.screen.splash.SplashScreen

@Composable
fun NavGraph() {
    val detailScreenParam = "locationName"
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRouting.SplashScreen.route,
    ) {

        composable(route = AppRouting.SplashScreen.route) {
            SplashScreen {
                navController.navigate(AppRouting.SearchScreen.route)
            }
        }

        composable(route = AppRouting.SearchScreen.route) {
            SearchScreen {
                navController.navigate(
                    "${AppRouting.DetailScreen.route}/{${detailScreenParam}}"
                        .replace(oldValue = "{${detailScreenParam}}", newValue = it)
                )
            }
        }

        composable(route = "${AppRouting.DetailScreen.route}/{${detailScreenParam}}") {
            val locationParam = it.arguments?.getString(detailScreenParam)
            locationParam?.let { param ->
                DetailScreen(locationName = param) {
                    navController.popBackStack()
                }
            }
        }
    }
}
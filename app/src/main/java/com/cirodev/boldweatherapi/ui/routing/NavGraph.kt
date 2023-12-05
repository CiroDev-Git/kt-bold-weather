package com.cirodev.boldweatherapi.ui.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cirodev.boldweatherapi.ui.screen.search.SearchScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRouting.SearchScreen.route,
    ) {

        composable(route = AppRouting.SearchScreen.route) {
            SearchScreen()
        }

        composable(route = AppRouting.DetailScreen.route) {
        }
    }
}
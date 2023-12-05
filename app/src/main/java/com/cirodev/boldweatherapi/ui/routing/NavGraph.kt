package com.cirodev.boldweatherapi.ui.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRouting.SearchScreen.route,
    ) {

        composable(route = AppRouting.SearchScreen.route) {
        }

        composable(route = AppRouting.DetailScreen.route) {
        }
    }
}
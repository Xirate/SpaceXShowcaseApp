package com.safiej.showcaseapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.safiej.showcaseapp.ui.LaunchpadScreen
import com.safiej.showcaseapp.ui.overview.OverviewScreen

@Composable
fun Navigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.OverviewScreen.route
    ) {
        composable(route = Screen.OverviewScreen.route) {
            OverviewScreen(navController = navController)
        }
        composable(route = Screen.LaunchpadsScreen.route) {
            LaunchpadScreen()
        }
    }
}
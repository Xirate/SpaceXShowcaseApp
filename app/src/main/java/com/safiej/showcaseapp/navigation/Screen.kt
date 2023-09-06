package com.safiej.showcaseapp.navigation

sealed class Screen(val route: String) {
    object OverviewScreen: Screen("overview_screen")
    object LaunchpadsScreen: Screen("launchpads_screen")
}
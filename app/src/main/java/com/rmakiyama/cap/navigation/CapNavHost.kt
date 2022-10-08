package com.rmakiyama.cap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rmakiyama.cap.ui.home.HomeRoute

@Composable
fun CapNavHost(
    navController: NavHostController,
    startDestination: String = CapDestination.home,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = CapDestination.home) {
            HomeRoute()
        }
    }
}

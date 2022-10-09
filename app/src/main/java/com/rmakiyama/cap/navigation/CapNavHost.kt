package com.rmakiyama.cap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rmakiyama.cap.model.BasicAnimatedContent
import com.rmakiyama.cap.model.BasicAnimatedVisibility
import com.rmakiyama.cap.ui.bac.BasicAnimatedVisibilityRoute
import com.rmakiyama.cap.ui.bav.BasicAnimatedContentRoute
import com.rmakiyama.cap.ui.home.HomeRoute

@Composable
fun CapNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    startDestination: String = CapDestination.home,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = CapDestination.home) {
            HomeRoute(
                navigateToPrototype = { prototype ->
                    navController.navigate(prototype.route)
                }
            )
        }
        composable(route = BasicAnimatedVisibility.javaClass.simpleName) {
            BasicAnimatedVisibilityRoute(
                onBackClick = onBackClick,
            )
        }
        composable(route = BasicAnimatedContent.javaClass.simpleName) {
            BasicAnimatedContentRoute(
                onBackClick = onBackClick,
            )
        }
    }
}

private fun navigate(route: String) {

}

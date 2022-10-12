package com.rmakiyama.cap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rmakiyama.cap.model.BasicAnimatedContent
import com.rmakiyama.cap.model.BasicAnimatedVisibility
import com.rmakiyama.cap.model.PlayingCards
import com.rmakiyama.cap.model.Progress
import com.rmakiyama.cap.ui.bac.BasicAnimatedVisibilityRoute
import com.rmakiyama.cap.ui.bav.BasicAnimatedContentRoute
import com.rmakiyama.cap.ui.home.HomeRoute
import com.rmakiyama.cap.ui.playingcards.PlayingCardsRoute
import com.rmakiyama.cap.ui.progress.ProgressRoute

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
        composable(route = Progress.javaClass.simpleName) {
            ProgressRoute(
                onBackClick = onBackClick,
            )
        }
        composable(route = PlayingCards.javaClass.simpleName) {
            PlayingCardsRoute(
                onBackClick = onBackClick,
            )
        }
    }
}

private fun navigate(route: String) {

}

package com.umain.code

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.umain.home.presentation.HomeScreen
import com.umain.home.presentation.HomeViewModel
import com.umain.navigation.destinations.HomeDestination
import com.umain.navigation.destinations.NavigationDestination

private fun composableDestinations(): Map<NavigationDestination, @Composable () -> Unit> =
    mapOf(
        HomeDestination to {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(state = viewModel.restaurantState.value)
        },
    )

fun NavGraphBuilder.addComposableDestinations() {
    composableDestinations().forEach { entry ->
        val destination = entry.key
        composable(
            destination.route, destination.arguments, destination.deepLinks
        ) {
            entry.value()
        }
    }
}

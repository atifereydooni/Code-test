package com.umain.code

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.umain.home.presentation.components.RestaurantDetailScreen
import com.umain.home.presentation.ui.HomeScreen
import com.umain.home.presentation.ui.HomeViewModel
import com.umain.navigation.destinations.HomeDestination
import com.umain.navigation.destinations.NavigationDestination
import com.umain.navigation.destinations.RestaurantDetailDestination

private fun composableDestinations(): Map<NavigationDestination, @Composable () -> Unit> =
    mapOf(
        HomeDestination to {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                state = viewModel.restaurantState.value,
                events = viewModel::onTriggerEvent
            )
        },
        RestaurantDetailDestination to {
            val viewModel: HomeViewModel = hiltViewModel()
            RestaurantDetailScreen(
                state = viewModel.restaurantState.value,
                events = viewModel::onTriggerEvent
            )
        },
    )

fun NavGraphBuilder.addComposableDestinations() {
    composableDestinations().forEach { entry ->
        val destination = entry.key
        composable(
            destination.route, destination.arguments, destination.deepLinks
        ) {
            if (destination.route.startsWith(RestaurantDetailDestination.DETAIL_ROUTE)) {
                val viewModel: HomeViewModel = hiltViewModel()
                viewModel.restaurantState.value = viewModel.restaurantState.value.copy(
                    selectedRestaurantId = it.arguments?.getString(RestaurantDetailDestination.RESTAURANT_PARAM)!!
                )
                RestaurantDetailScreen(
                    state = viewModel.restaurantState.value,
                    events = viewModel::onTriggerEvent
                )
            } else {
                entry.value()
            }
        }
    }
}


package com.umain.home.presentation.ui

import androidx.compose.runtime.Composable
import com.umain.home.presentation.components.RestaurantList

@Composable
fun HomeScreen(
    state: RestaurantState,
    events: (RestaurantEvents) -> Unit = {}
) {
    RestaurantList(state, events)
}
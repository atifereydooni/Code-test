package com.umain.home.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.umain.home.presentation.components.FilterList
import com.umain.home.presentation.components.RestaurantList

@Composable
fun HomeScreen(
    state: RestaurantState,
    events: (RestaurantEvents) -> Unit = {}
) {
    Column {
        FilterList(state = state, events = events)
        RestaurantList(state, events)
    }
}
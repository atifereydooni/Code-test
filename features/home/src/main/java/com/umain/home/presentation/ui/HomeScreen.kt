package com.umain.home.presentation.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.umain.home.presentation.components.RestaurantList

@Composable
fun HomeScreen(
    state: RestaurantState
) {
    RestaurantList(state)
}
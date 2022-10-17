package com.umain.home.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    state: RestaurantState
) {
    Text(state.restaurantsEntity.toString())
}
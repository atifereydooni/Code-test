package com.umain.home.presentation.ui

import com.umain.home.domain.model.Restaurant

sealed class RestaurantEvents {

    data class NavigateToRestaurantEvent(val restaurant: Restaurant) : RestaurantEvents()

}
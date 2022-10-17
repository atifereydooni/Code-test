package com.umain.home.presentation.ui

import com.umain.home.domain.model.RestaurantEntity

data class RestaurantState(
    val errorMessage: String = "",
    val restaurantsEntity: RestaurantEntity = RestaurantEntity(listOf())
)

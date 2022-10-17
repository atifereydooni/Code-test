package com.umain.home.presentation

import com.umain.home.domain.model.RestaurantEntity

data class RestaurantState(
    val errorMessage: String = "",
    val restaurantsEntity: RestaurantEntity = RestaurantEntity(listOf())
)

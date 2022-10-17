package com.umain.home.domain.model

data class RestaurantEntity(
    val restaurants: List<Restaurant>
)

data class Restaurant(
    val delivery_time_minutes: Int,
    val filterIds: List<String>,
    val id: String,
    val image_url: String,
    val name: String,
    val rating: Double
)
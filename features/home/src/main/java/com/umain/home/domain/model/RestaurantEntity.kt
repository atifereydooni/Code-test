package com.umain.home.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RestaurantEntity(
    val restaurants: List<Restaurant>
)

@JsonClass(generateAdapter = true)
data class Restaurant(
    val delivery_time_minutes: Int,
    val filterIds: List<String>,
    val id: String,
    val image_url: String,
    val name: String,
    val rating: Double
)
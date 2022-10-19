package com.umain.home.presentation.ui

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import com.umain.home.domain.model.Restaurant
import com.umain.home.domain.model.RestaurantEntity

data class RestaurantState(
    val errorMessage: String = "",
    val restaurantsEntity: RestaurantEntity = RestaurantEntity(mutableListOf()),
    val filterMap: SnapshotStateMap<String, Pair<String, String>> = mutableStateMapOf(),
    val selectedRestaurant: Restaurant? = null,
    val selectedRestaurantId: String =""
)

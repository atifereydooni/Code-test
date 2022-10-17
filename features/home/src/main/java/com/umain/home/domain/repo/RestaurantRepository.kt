package com.umain.home.domain.repo

import com.umain.home.domain.model.RestaurantEntity
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {

    suspend fun getRestaurants(): Flow<RestaurantEntity>

}

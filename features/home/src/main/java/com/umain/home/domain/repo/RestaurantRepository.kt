package com.umain.home.domain.repo

import com.umain.home.domain.model.FilterEntity
import com.umain.home.domain.model.OpenEntity
import com.umain.home.domain.model.RestaurantEntity
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {

    suspend fun getRestaurants(): Flow<RestaurantEntity>

    suspend fun getFilter(filterId: String): Flow<FilterEntity>

    suspend fun getOpen(restaurantId: String): Flow<OpenEntity>

}

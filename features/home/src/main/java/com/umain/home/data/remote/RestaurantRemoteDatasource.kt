package com.umain.home.data.remote

import com.umain.home.domain.model.FilterEntity
import com.umain.home.domain.model.RestaurantEntity

interface RestaurantRemoteDatasource {

    suspend fun getRestaurants(): RestaurantEntity

    suspend fun getFilter(filterId: String): FilterEntity

}

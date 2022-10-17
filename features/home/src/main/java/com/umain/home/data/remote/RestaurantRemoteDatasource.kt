package com.umain.home.data.remote

import com.umain.home.domain.model.RestaurantEntity

interface RestaurantRemoteDatasource {

    suspend fun getRestaurants(): RestaurantEntity

}

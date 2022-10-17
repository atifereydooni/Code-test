package com.umain.home.data.remote

import com.umain.home.domain.model.RestaurantEntity

class RestaurantRemoteDatasourceImpl(private val api: RestaurantApiService) :
    RestaurantRemoteDatasource {

    override suspend fun getRestaurants(): RestaurantEntity {
        return api.getRestaurants()
    }

}

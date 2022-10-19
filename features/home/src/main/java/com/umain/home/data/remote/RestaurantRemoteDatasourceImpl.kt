package com.umain.home.data.remote

import com.umain.home.domain.model.FilterEntity
import com.umain.home.domain.model.OpenEntity
import com.umain.home.domain.model.RestaurantEntity

class RestaurantRemoteDatasourceImpl(private val api: RestaurantApiService) :
    RestaurantRemoteDatasource {

    override suspend fun getRestaurants(): RestaurantEntity {
        return api.getRestaurants()
    }

    override suspend fun getFilter(filterId: String): FilterEntity {
        return api.getFilter(filterId)
    }

    override suspend fun getOpen(restaurantId: String): OpenEntity {
        return api.getOpen(restaurantId)
    }

}

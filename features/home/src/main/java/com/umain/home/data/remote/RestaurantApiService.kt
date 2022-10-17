package com.umain.home.data.remote

import com.umain.home.domain.model.RestaurantEntity
import retrofit2.http.GET

interface RestaurantApiService {

    @GET("/restaurants")
    suspend fun getRestaurants(): RestaurantEntity

}

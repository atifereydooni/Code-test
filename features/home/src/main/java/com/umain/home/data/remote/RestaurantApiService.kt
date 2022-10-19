package com.umain.home.data.remote

import com.umain.home.domain.model.FilterEntity
import com.umain.home.domain.model.OpenEntity
import com.umain.home.domain.model.RestaurantEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApiService {

    @GET("/restaurants")
    suspend fun getRestaurants(): RestaurantEntity

    @GET("/filter/{filterId}")
    suspend fun getFilter(@Path("filterId") filterId: String): FilterEntity

    @GET("/open/{restaurantId}")
    suspend fun getOpen(@Path("restaurantId") restaurantId: String): OpenEntity

}

package com.umain.home.data

import com.umain.home.data.remote.RestaurantRemoteDatasource
import com.umain.home.domain.model.FilterEntity
import com.umain.home.domain.model.RestaurantEntity
import com.umain.home.domain.repo.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(private val remote: RestaurantRemoteDatasource) :
    RestaurantRepository {
    override suspend fun getRestaurants(): Flow<RestaurantEntity> {
        return flowOf(remote.getRestaurants())
    }

    override suspend fun getFilter(filterId: String): Flow<FilterEntity> {
        return flowOf(remote.getFilter(filterId))
    }


}

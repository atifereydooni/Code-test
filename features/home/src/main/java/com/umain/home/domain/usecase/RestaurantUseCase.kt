package com.umain.home.domain.usecase

import com.umain.home.domain.model.RestaurantEntity
import com.umain.home.domain.repo.RestaurantRepository
import com.umain.home.handleRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestaurantUseCase @Inject constructor(private val repository: RestaurantRepository) {

    suspend fun getRestaurants(): Result<Flow<RestaurantEntity>> {
        return handleRequest {
            repository.getRestaurants()
        }
    }
}

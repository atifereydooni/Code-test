package com.umain.home.domain.usecase

import com.umain.home.domain.model.OpenEntity
import com.umain.home.domain.repo.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OpenUseCase @Inject constructor(private val repository: RestaurantRepository) {

    suspend fun getOpen(restaurantId: String): Flow<OpenEntity> {
        return repository.getOpen(restaurantId)
    }
}

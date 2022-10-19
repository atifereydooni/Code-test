package com.umain.home.domain.usecase

import com.umain.home.domain.model.FilterEntity
import com.umain.home.domain.repo.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilterUseCase @Inject constructor(private val repository: RestaurantRepository) {

    suspend fun getFilter(filterId: String): Flow<FilterEntity> {
        return repository.getFilter(filterId)
    }
}

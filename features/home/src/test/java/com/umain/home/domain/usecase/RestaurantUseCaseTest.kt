package com.umain.home.domain.usecase

import com.umain.home.domain.model.FakeRestaurantEntity
import com.umain.home.domain.model.RestaurantEntity
import com.umain.home.domain.repo.RestaurantRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RestaurantUseCaseTest {

    // Mock
    private val restaurantRepository: RestaurantRepository = mockk()
    private var fakeRestaurantEntity = FakeRestaurantEntity()

    // Class for test
    private val restaurantUseCase = RestaurantUseCase(restaurantRepository)

    @Test
    fun `when use case execute then repository called`() =
        runBlocking {

            // Given
            coEvery {
                restaurantRepository.getRestaurants()
            } returns flow {
                RestaurantEntity(listOf())
            }

            // When
            restaurantUseCase.getRestaurants()

            // Then
            coVerify {
                restaurantRepository.getRestaurants()
            }

        }

    @Test
    fun `when use case execute then the result is success`() =
        runBlocking {

            // Given
            coEvery {
                restaurantUseCase.getRestaurants()
            } returns Result.success(flow { fakeRestaurantEntity.getFakeRestaurantEntity() })

            // When
            val flowResult = restaurantUseCase.getRestaurants()

            // Then
            assert(flowResult.isSuccess)

        }

}
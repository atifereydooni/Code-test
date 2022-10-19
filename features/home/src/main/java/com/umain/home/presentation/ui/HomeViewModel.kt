package com.umain.home.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umain.home.domain.model.Restaurant
import com.umain.home.domain.usecase.FilterUseCase
import com.umain.home.domain.usecase.RestaurantUseCase
import com.umain.navigation.INavigationManager
import com.umain.navigation.destinations.RestaurantDetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val navigationManager: INavigationManager,
    private val restaurantUseCase: RestaurantUseCase,
    private val filterUseCase: FilterUseCase
) : ViewModel() {

    val restaurantState: MutableState<RestaurantState> = mutableStateOf(RestaurantState())

    init {
        getRestaurants()
    }

    fun onTriggerEvent(events: RestaurantEvents) {
        when (events) {
            is RestaurantEvents.NavigateToRestaurantEvent -> {
                navigateToRestaurantDetail(events.restaurant)
            }
        }
    }

    private fun getRestaurants() {
        viewModelScope.launch {
            restaurantUseCase.getRestaurants().onSuccess { flow ->
                flow.collect {
                    restaurantState.value =
                        restaurantState.value.copy(
                            restaurantsEntity = it
                        )
                    setSelectedRestaurant()

                    for (restaurant in restaurantState.value.restaurantsEntity.restaurants) {
                        for (i in 0 until restaurant.filterIds.size) {
                            if (!restaurantState.value.filterMap.containsKey(restaurant.filterIds[i]))
                                getFilter(restaurant.filterIds[i])
                        }
                    }
                }
            }.onFailure {
                restaurantState.value =
                    restaurantState.value.copy(
                        errorMessage = it.message.toString()
                    )
            }
        }
    }

    private fun getFilter(filterId: String) {
        viewModelScope.launch {
            filterUseCase.getFilter(filterId).collect {
                restaurantState.value.filterMap[filterId] = Pair(it.name, it.image_url)
            }
        }
    }

    private fun navigateToRestaurantDetail(restaurant: Restaurant) {
        viewModelScope.launch {
            navigationManager.navigateTo(
                RestaurantDetailDestination.createDetailRoute(restaurant.id)
            )
        }
    }

    private fun setSelectedRestaurant() {
        for (restaurantEntity in restaurantState.value.restaurantsEntity.restaurants) {
            if (restaurantEntity.id == restaurantState.value.selectedRestaurantId) {
                restaurantState.value =
                    restaurantState.value.copy(
                        selectedRestaurant = restaurantEntity
                    )
            }
        }
    }

}


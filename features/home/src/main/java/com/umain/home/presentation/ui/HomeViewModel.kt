package com.umain.home.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umain.home.domain.usecase.FilterUseCase
import com.umain.home.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val restaurantUseCase: RestaurantUseCase,
    private val filterUseCase: FilterUseCase
) : ViewModel() {

    val restaurantState: MutableState<RestaurantState> = mutableStateOf(RestaurantState())

    init {
        getRestaurants()
    }

    private fun getRestaurants() {
        viewModelScope.launch {
            restaurantUseCase.getRestaurants().onSuccess { flow ->
                flow.collect {
                    restaurantState.value =
                        restaurantState.value.copy(
                            restaurantsEntity = it
                        )
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

}


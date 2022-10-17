package com.umain.home.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umain.home.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val restaurantUseCase: RestaurantUseCase
) : ViewModel() {

    init {
        getRestaurants()
    }

    val restaurantState: MutableState<RestaurantState> = mutableStateOf(RestaurantState())

    private fun getRestaurants() {
        viewModelScope.launch {
            restaurantUseCase.getRestaurants().onSuccess {
                it.collect {
                    restaurantState.value =
                        restaurantState.value.copy(
                            restaurantsEntity = it
                        )
                }
            }.onFailure {
                restaurantState.value =
                    restaurantState.value.copy(
                        errorMessage = it.message.toString()
                    )
            }
        }
    }

}


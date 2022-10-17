package com.umain.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.umain.home.presentation.ui.RestaurantState

@Composable
fun RestaurantList(
    state: RestaurantState,
) {
    LazyColumn(
        modifier = Modifier
            .testTag(TagScrollableList)
            .background(Color.Gray)
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(state.restaurantsEntity.restaurants.size) { index ->
            RestaurantItem(
                restaurant = state.restaurantsEntity.restaurants[index],
                onClick = {

                }
            )
        }
    }
}

const val TagScrollableList = "TagScrollableList"

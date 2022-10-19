package com.umain.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.umain.home.presentation.ui.RestaurantEvents
import com.umain.home.presentation.ui.RestaurantState
import com.umain.theme.Background
import com.umain.theme.margin16Dp
import com.umain.theme.margin20Dp

@Composable
fun RestaurantList(
    state: RestaurantState,
    events: (RestaurantEvents) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .testTag(TagScrollableList)
            .background(Background)
            .padding(top = margin20Dp),
        verticalArrangement = Arrangement.spacedBy(margin16Dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(state.filteredRestaurantList.size) { index ->
            RestaurantItem(
                state = state,
                restaurant = state.filteredRestaurantList[index],
                onClick = {
                    events(RestaurantEvents.NavigateToRestaurantEvent(it))
                }
            )
        }
    }
}

const val TagScrollableList = "TagScrollableList"

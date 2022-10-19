package com.umain.home.presentation.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.umain.home.presentation.ui.RestaurantEvents
import com.umain.home.presentation.ui.RestaurantState
import com.umain.theme.Background
import com.umain.theme.Selected

@Composable
fun FilterList(
    state: RestaurantState,
    events: (RestaurantEvents) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(top = 24.dp, end = 16.dp, bottom = 27.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {

        state.filterMap.forEach { filter ->
            var isSelected by remember { mutableStateOf(false) }
            FilterItem(filterName = filter.value.first, isSelected = isSelected, onSelected = {
                isSelected = it
                events(RestaurantEvents.AddSelectedFilterEvent(filter.key, it))
            })
        }
    }
}

@Composable
fun FilterItem(
    filterName: String,
    isSelected: Boolean,
    onSelected: (isSelected: Boolean) -> Unit
) {
    Surface(
        modifier = Modifier.toggleable(
            value = isSelected,
            onValueChange = {
                onSelected(!isSelected)
            }
        ),
        elevation = if (isSelected) 0.dp else 2.dp,
        shape = RoundedCornerShape(32.dp),
        color = when (isSelected) {
            true -> Selected
            false -> Background
        }
    ) {
        Row {
            val modifier = Modifier.padding(
                top = 13.dp,
                bottom = 13.dp,
                start = 11.dp,
                end = 11.dp
            )
            Text(
                modifier = modifier,
                text = filterName,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
            )
        }
    }

}




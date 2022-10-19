package com.umain.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.umain.home.presentation.ui.RestaurantEvents
import com.umain.home.presentation.ui.RestaurantState
import com.umain.theme.*

@Composable
fun FilterList(
    state: RestaurantState,
    events: (RestaurantEvents) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
            .horizontalScroll(rememberScrollState())
            .padding(top = margin16Dp, bottom = margin5Dp),
        horizontalArrangement = Arrangement.spacedBy(margin5Dp),
    ) {

        state.filterMap.forEach { filter ->
            var isSelected by remember { mutableStateOf(false) }
            FilterItem(
                filterName = filter.value.first,
                filterImage = filter.value.second,
                isSelected = isSelected,
                onSelected = {
                    isSelected = it
                    events(RestaurantEvents.AddSelectedFilterEvent(filter.key, it))
                })
        }
    }
}

@Composable
fun FilterItem(
    filterName: String,
    filterImage: String,
    isSelected: Boolean,
    onSelected: (isSelected: Boolean) -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(start = margin16Dp)
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelected(!isSelected)
                }
            ),
        elevation = if (isSelected) 0.dp else 2.dp,
        shape = RoundedCornerShape(roundedShapeSize),
        color = when (isSelected) {
            true -> Selected
            false -> Background
        }
    ) {
        Row {
            Image(
                modifier = Modifier
                    .width(imageFilterSize)
                    .height(imageFilterSize),
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(filterImage),
                contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(margin16Dp),
                text = filterName,
                textAlign = TextAlign.Center,
                fontSize = fontSize14Sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}




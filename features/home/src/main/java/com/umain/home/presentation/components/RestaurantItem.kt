package com.umain.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.umain.home.domain.model.Restaurant

@Composable
fun RestaurantItem(
    restaurant: Restaurant,
    onClick: (restaurant: Restaurant) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .background(
                color = White
            )
            .clickable {
                onClick(restaurant)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .wrapContentWidth(),
                style = TextStyle(
                    color = Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                text = restaurant.name
            )
            Text(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 5.dp,
                        end = 16.dp
                    )
                    .wrapContentWidth(),
                style = TextStyle(
                    color = Gray,
                    fontSize = 16.sp
                ),
                text = "${restaurant.delivery_time_minutes}"
            )
        }

    }
}


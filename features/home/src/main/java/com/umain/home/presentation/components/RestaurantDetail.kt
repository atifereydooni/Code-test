package com.umain.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberImagePainter
import com.umain.home.presentation.ui.RestaurantState
import com.umain.theme.*

@Composable
fun RestaurantDetailScreen(
    state: RestaurantState
) {
    if (state.selectedRestaurant != null) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageDetailSize),
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(state.selectedRestaurant.image_url),
                contentDescription = ""
            )
        }
        Card(
            elevation = margin5Dp,
            onClick = {
            },
            shape = RoundedCornerShape(margin20Dp),
            backgroundColor = Background,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = marginTopImageDetail, start = margin20Dp, end = margin20Dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(margin20Dp)
            ) {
                Text(
                    style = TextStyle(
                        color = DarkText,
                        fontSize = fontSize22Sp
                    ),
                    text = state.selectedRestaurant.name
                )
                LazyRow(
                    modifier = Modifier
                        .padding(top = margin12Dp)
                ) {
                    items(state.selectedRestaurant.filterIds.size) { index ->
                        Text(
                            style = TextStyle(
                                color = Subtitle,
                                fontSize = fontSize14Sp,
                                fontWeight = FontWeight.Bold
                            ),
                            text = if (state.filterMap.containsKey(state.selectedRestaurant.filterIds[index])) {
                                if (index == 0) {
                                    state.filterMap[state.selectedRestaurant.filterIds[index]]!!.first
                                } else {
                                    " . ${state.filterMap[state.selectedRestaurant.filterIds[index]]!!.first}"
                                }
                            } else {
                                ""
                            }
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(top = margin12Dp),
                    style = TextStyle(
                        color = if (state.selectedRestaurantOpen) Positive else Negative,
                        fontSize = fontSize22Sp
                    ),
                    text = if (state.selectedRestaurantOpen) "Open" else "Close"
                )
            }
        }

    }
}



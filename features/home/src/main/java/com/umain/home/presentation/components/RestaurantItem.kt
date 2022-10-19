package com.umain.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberImagePainter
import com.umain.home.R
import com.umain.home.domain.model.Restaurant
import com.umain.home.presentation.ui.RestaurantState
import com.umain.theme.*

@Composable
fun RestaurantItem(
    state: RestaurantState,
    restaurant: Restaurant,
    onClick: (restaurant: Restaurant) -> Unit
) {
    Card(
        elevation = margin5Dp,
        onClick = {
            onClick(restaurant)
        },
        shape = RoundedCornerShape(topEnd = margin20Dp, topStart = margin20Dp),
        backgroundColor = Background,
        modifier = Modifier
            .padding(start = margin20Dp, end = margin20Dp)
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = margin8Dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageListSize),
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(restaurant.image_url),
                contentDescription = ""
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = margin8Dp, end = margin8Dp, top = margin8Dp),
                    style = TextStyle(
                        color = DarkText,
                        fontSize = fontSize18Sp
                    ),
                    text = restaurant.name
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = com.umain.home.R.drawable.ic_star),
                        contentDescription = ""
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = margin5Dp, end = margin8Dp),
                        style = TextStyle(
                            color = MiddleText,
                            fontSize = fontSize14Sp,
                            fontWeight = FontWeight.Bold
                        ),
                        text = "${restaurant.rating}"
                    )
                }
            }
            LazyRow(
                modifier = Modifier
                    .padding(start = margin8Dp)
            ) {
                items(restaurant.filterIds.size) { index ->
                    Text(
                        style = TextStyle(
                            color = Subtitle,
                            fontSize = fontSize14Sp,
                            fontWeight = FontWeight.Bold
                        ),
                        text = if (state.filterMap.containsKey(restaurant.filterIds[index])) {
                            if (index == 0) {
                                state.filterMap[restaurant.filterIds[index]]!!.first
                            } else {
                                " . ${state.filterMap[restaurant.filterIds[index]]!!.first}"
                            }
                        } else {
                            ""
                        }
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = margin8Dp, end = margin8Dp, top = margin5Dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_timer),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(start = margin5Dp),
                    style = TextStyle(
                        color = MiddleText,
                        fontSize = fontSize12Sp,
                        fontWeight = FontWeight.Bold
                    ),
                    text = if (restaurant.delivery_time_minutes == 1) "${restaurant.delivery_time_minutes} min" else "${restaurant.delivery_time_minutes} mins"
                )
            }
        }
    }
}



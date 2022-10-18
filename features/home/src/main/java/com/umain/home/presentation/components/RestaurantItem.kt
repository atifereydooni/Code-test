package com.umain.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.umain.home.domain.model.Restaurant
import com.umain.theme.*

@Composable
fun RestaurantItem(
    restaurant: Restaurant,
    onClick: (restaurant: Restaurant) -> Unit
) {
    Card(
        elevation = margin5Dp,
        onClick = {
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
                contentDescription = "mystudio"
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
                        fontSize = fontSize18Dp
                    ),
                    text = restaurant.name
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = com.umain.home.R.drawable.ic_star),
                        contentDescription = "mystudio"
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = margin5Dp, end = margin8Dp),
                        style = TextStyle(
                            color = MiddleText,
                            fontSize = fontSize14Dp,
                            fontWeight = FontWeight.Bold
                        ),
                        text = "${restaurant.rating}"
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(start = margin8Dp, end = margin8Dp)
                    .wrapContentWidth(),
                style = TextStyle(
                    color = Subtitle,
                    fontSize = fontSize15Dp,
                    fontWeight = FontWeight.Bold
                ),
                text = "Take-Out"
            )
            Row(
                modifier = Modifier
                    .padding(start = margin8Dp, end = margin8Dp, top= margin5Dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = com.umain.home.R.drawable.ic_timer),
                    contentDescription = "mystudio"
                )
                Text(
                    modifier = Modifier
                        .padding(start = margin5Dp),
                    style = TextStyle(
                        color = MiddleText,
                        fontSize = fontSize12Dp,
                        fontWeight = FontWeight.Bold
                    ),
                    text = if (restaurant.delivery_time_minutes == 1) "${restaurant.delivery_time_minutes} min" else "${restaurant.delivery_time_minutes} mins"
                )
            }
        }
    }
}


package com.umain.home.domain.model

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRestaurantEntity {

        private val jsonRestaurantEntity = "{\n" +
                "    \"restaurants\": [\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 9,\n" +
                "            \"name\": \"Wayne \\\"Chad Broski\\\" Burgers\",\n" +
                "            \"rating\": 4.6,\n" +
                "            \"filterIds\": [\n" +
                "                \"5c64dea3-a4ac-4151-a2e3-42e7919a925d\",\n" +
                "                \"614fd642-3fa6-4f15-8786-dd3a8358cd78\",\n" +
                "                \"c67cd8a3-f191-4083-ad28-741659f214d7\",\n" +
                "                \"23a38556-779e-4a3b-a75b-fcbc7a1c7a20\"\n" +
                "            ],\n" +
                "            \"id\": \"7450001\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/burgers.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 45,\n" +
                "            \"name\": \"Yuma´s Candyshop\",\n" +
                "            \"rating\": 4.7,\n" +
                "            \"filterIds\": [\n" +
                "                \"5c64dea3-a4ac-4151-a2e3-42e7919a925d\"\n" +
                "            ],\n" +
                "            \"id\": \"7450002\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/candy.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 1,\n" +
                "            \"name\": \"Emilia´s Fancy Food\",\n" +
                "            \"rating\": 4.1,\n" +
                "            \"filterIds\": [\n" +
                "                \"5c64dea3-a4ac-4151-a2e3-42e7919a925d\",\n" +
                "                \"23a38556-779e-4a3b-a75b-fcbc7a1c7a20\",\n" +
                "                \"0017e59c-4407-453f-a5be-901695708015\"\n" +
                "            ],\n" +
                "            \"id\": \"7450007\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/meat.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 3,\n" +
                "            \"name\": \"Pizzeria Varsha\",\n" +
                "            \"rating\": 4.4,\n" +
                "            \"filterIds\": [\n" +
                "                \"23a38556-779e-4a3b-a75b-fcbc7a1c7a20\",\n" +
                "                \"c67cd8a3-f191-4083-ad28-741659f214d7\"\n" +
                "            ],\n" +
                "            \"id\": \"7450010\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/pizza.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 17,\n" +
                "            \"name\": \"Guillaume´s Croissants\",\n" +
                "            \"rating\": 5,\n" +
                "            \"filterIds\": [\n" +
                "                \"5c64dea3-a4ac-4151-a2e3-42e7919a925d\",\n" +
                "                \"0017e59c-4407-453f-a5be-901695708015\"\n" +
                "            ],\n" +
                "            \"id\": \"7450013\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/croissants.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 45,\n" +
                "            \"name\": \"Martin´s Mancave\",\n" +
                "            \"rating\": 3.6,\n" +
                "            \"filterIds\": [\n" +
                "                \"0017e59c-4407-453f-a5be-901695708015\"\n" +
                "            ],\n" +
                "            \"id\": \"7450040\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/beer.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 12,\n" +
                "            \"name\": \"Henriks Muddy Water\",\n" +
                "            \"rating\": 0.7,\n" +
                "            \"filterIds\": [\n" +
                "                \"c67cd8a3-f191-4083-ad28-741659f214d7\"\n" +
                "            ],\n" +
                "            \"id\": \"7450041\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/coffee.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 45,\n" +
                "            \"name\": \"Pontus Expired Yogurts\",\n" +
                "            \"rating\": 1.2,\n" +
                "            \"filterIds\": [],\n" +
                "            \"id\": \"7450042\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/yogurt.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"delivery_time_minutes\": 60,\n" +
                "            \"name\": \"Merts Bed & Breakfast\",\n" +
                "            \"rating\": 2.7,\n" +
                "            \"filterIds\": [\n" +
                "                \"0017e59c-4407-453f-a5be-901695708015\"\n" +
                "            ],\n" +
                "            \"id\": \"7450043\",\n" +
                "            \"image_url\": \"https://elgfors.se/code-test/restaurant/bread.png\"\n" +
                "        }\n" +
                "    ]\n" +
                "}"

        fun getFakeRestaurantEntity(): RestaurantEntity {
            val moshi: Moshi = Moshi.Builder().build()
            val adapter: JsonAdapter<RestaurantEntity> =
                moshi.adapter(RestaurantEntity::class.java)
            val restaurantEntity = adapter.fromJson(jsonRestaurantEntity)
            return restaurantEntity!!
        }

}
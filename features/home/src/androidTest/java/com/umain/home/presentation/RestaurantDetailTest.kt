package com.umain.home.presentation

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import com.umain.home.domain.model.FakeRestaurantEntity
import com.umain.home.presentation.components.RestaurantDetailScreen
import com.umain.home.presentation.components.TagRestaurantDetail
import com.umain.home.presentation.ui.RestaurantState
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class RestaurantDetailTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createComposeRule()

    val state = RestaurantState()

    @Before
    fun setup() {
        composeTestRule.setContent {
            RestaurantDetailScreen(state = state)
        }
    }

    @Test
    fun restaurantDetailNotExist() {
        composeTestRule.onAllNodes(!hasTestTag(TagRestaurantDetail))
    }

    @Test
    fun restaurantDetailExist() {
        val fakeRestaurantEntity = FakeRestaurantEntity()
        state.copy(
            restaurantsEntity = fakeRestaurantEntity.getFakeRestaurantEntity()
        )
        composeTestRule.onAllNodes(!hasTestTag(TagRestaurantDetail))
    }

}

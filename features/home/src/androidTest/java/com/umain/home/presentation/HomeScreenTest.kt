package com.umain.home.presentation

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import com.umain.home.presentation.components.TagFilterList
import com.umain.home.presentation.components.TagScrollableList
import com.umain.home.presentation.ui.HomeScreen
import com.umain.home.presentation.ui.RestaurantState
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class HomeScreenTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createComposeRule()

    val state = RestaurantState()

    @Before
    fun setup() {
        composeTestRule.setContent {
            HomeScreen(state = state)
        }
    }

    @Test
    fun restaurantListExist() {
        composeTestRule.onAllNodes(hasTestTag(TagScrollableList))
    }

    @Test
    fun filterListExist() {
        composeTestRule.onAllNodes(hasTestTag(TagFilterList))
    }

    @Test
    fun loadingViewExist() {
        composeTestRule.onAllNodes(hasTestTag(TagFilterList))
    }

}

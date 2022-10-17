package com.umain.code

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.flow.collect
import com.umain.navigation.INavigationManager
import com.umain.navigation.NavigationEvent
import com.umain.navigation.destinations.LoginDestination

@Composable
fun MainScaffold(
    navigationManager: INavigationManager
) {
    val navController = rememberAnimatedNavController()
    val scaffoldState = rememberScaffoldState()
    NavigationEvent(
        navController = navController,
        navigationManager = navigationManager
    )
    Scaffold(scaffoldState = scaffoldState) {
        AnimatedNavHost(
            navController = navController,
            startDestination = LoginDestination.route,
            builder = {
                addComposableDestinations()
            }
        )
    }
}

@Composable
private fun NavigationEvent(
    navController: NavHostController,
    navigationManager: INavigationManager
) {
    LaunchedEffect(navController) {
        navigationManager.navigationEvents.collect {
            when (val event = it) {
                is NavigationEvent.NavigateUp -> navController.navigateUp()
                is NavigationEvent.NavigateTo ->
                    navController.navigate(
                        event.route,
                        event.builder
                    )
            }
        }
    }
}


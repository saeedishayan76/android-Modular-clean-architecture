package com.shayan.naviagtion

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.shayan.presentation.ProfileScreen

fun NavGraphBuilder.profileGraph(navController: NavController) {
    navigation(
        startDestination = ProfileScreens.ProfileScreen.route,
        route = ProfileScreens.ProfileGraph.route
    ) {
        composable(ProfileScreens.ProfileScreen.route) {
            ProfileScreen()
        }
    }
}
package com.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ui.DetailScreen
import com.ui.home.HomeScreen


private const val TAG = "homeGraph"
fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        startDestination = HomeScreens.HomeScreen.route,
        route = HomeScreens.HomeNavGraph.route
    ) {
        composable(HomeScreens.HomeScreen.route) {
            HomeScreen(
                navigateTo = { route ->
                    navController.navigate(route = route)
                }
            )
        }
        composable(
            HomeScreens.DetailScreen.route + "/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            val userId = it.arguments?.getInt("id") ?: -1
            DetailScreen(id = userId)
        }
    }
}




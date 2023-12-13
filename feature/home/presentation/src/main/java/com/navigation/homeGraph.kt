package com.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.model.User
import com.ui.DetailScreen
import com.ui.HomeScreen


private const val TAG = "homeGraph"
fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        startDestination = HomeScreens.HomeScreen.route,
        route = HomeScreens.HomeNavGraph.route
    ) {
        composable(HomeScreens.HomeScreen.route) {
            HomeScreen(
                onTitleClicked = {
                    Log.i(TAG, "homeNavGraph: user $it")
                    navController.navigate(HomeScreens.DetailScreen.route+"/${it}")
                },
                onProfileClicked = {
                    // Question
                    navController.navigate("ProfileRoute")
                },
                navigateTo = { route ->
                   //
                }
            )
        }
        composable(HomeScreens.DetailScreen.route+"/{title}") {
            val title = it.arguments?.get
            Log.i(TAG, "homeNavGraph: title $title")
            DetailScreen()
        }
    }
}
package com.navigation

sealed class HomeScreens(val route: String){
    object HomeScreen: HomeScreens("Home")
    object DetailScreen: HomeScreens("Detail")
    object HomeNavGraph: HomeScreens("HomeRoute")
}

package com.shayan.conventionmodular.bottomNav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.navigation.HomeScreens
import com.navigation.homeNavGraph
import com.shayan.naviagtion.profileGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RootNavHost() {

    // A surface container using the 'background' color from the theme

    val navController = rememberNavController()
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,

        )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
            ) {
                if (showBottomBar) {
                    val currentDestination = navBackStackEntry?.destination

                    screens.forEach { screen ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Black,
                                unselectedIconColor = Color.Gray,
                                selectedTextColor = Color.Black,
                                unselectedTextColor = Color.Gray
                            ),
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = screen.icon),
                                    contentDescription = screen.route
                                )
                            },
                            label = {
                                Text(text = screen.route.replace("Route", " "))
                            }
                        )
                    }
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeScreens.HomeNavGraph.route
        ) {
            homeNavGraph(navController)
            profileGraph(navController)
        }
    }
    showBottomBar =
        when (navBackStackEntry?.destination?.route) { // on this screen bottom bar should be hidden
            HomeScreens.DetailScreen.route -> false // here too
            else -> true // in all other cases show bottom bar
        }


}
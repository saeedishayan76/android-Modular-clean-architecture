package com.shayan.conventionmodular.bottomNav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.navigation.HomeScreens
import com.shayan.conventionmodular.R
import com.shayan.naviagtion.ProfileScreens

sealed class BottomBarScreen(val route: String, @StringRes val resourceId: Int, @DrawableRes val icon: Int) {
    object Home : BottomBarScreen(HomeScreens.HomeNavGraph.route, R.string.home, R.drawable.baseline_home_24)
    object Profile : BottomBarScreen(ProfileScreens.ProfileGraph.route, R.string.profile, R.drawable.baseline_person_24)
}
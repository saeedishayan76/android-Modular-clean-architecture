package com.shayan.conventionmodular.bottomNav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.naviagtion.NoteScreens
import com.navigation.HomeScreens
import com.shayan.conventionmodular.R

sealed class BottomBarScreen(val route: String, @StringRes val resourceId: Int, @DrawableRes val icon: Int) {
    object Home : BottomBarScreen(HomeScreens.HomeNavGraph.route, R.string.home, R.drawable.baseline_home_24)
    object Note : BottomBarScreen(NoteScreens.NoteGraph.route, R.string.note, R.drawable.baseline_person_24)
}
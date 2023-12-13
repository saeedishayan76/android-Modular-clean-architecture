package com.shayan.naviagtion

sealed class ProfileScreens(val route: String){
    object ProfileScreen: ProfileScreens("profile")
    object ProfileGraph: ProfileScreens("ProfileRoute")
}

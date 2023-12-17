package com.naviagtion

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ui.AddNoteScreen
import com.ui.NoteScreen

fun NavGraphBuilder.noteGraph(navController: NavController) {
    navigation(
        startDestination = NoteScreens.NoteScreen.route,
        route = NoteScreens.NoteGraph.route
    ) {
        composable(NoteScreens.NoteScreen.route) {
            NoteScreen(){
                navController.navigate(route = it)
            }
        }
        composable(NoteScreens.AddNoteScreen.route) {
            AddNoteScreen{
                navController.navigateUp()
            }
        }
    }
}
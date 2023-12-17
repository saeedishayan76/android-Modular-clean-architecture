package com.naviagtion

sealed class NoteScreens(val route: String){
    object NoteScreen: NoteScreens("note")
    object AddNoteScreen: NoteScreens("addNote")
    object NoteGraph: NoteScreens("NoteRoute")
}

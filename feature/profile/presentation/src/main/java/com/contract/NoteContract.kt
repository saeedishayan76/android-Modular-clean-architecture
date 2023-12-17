package com.contract

import com.ViewEvent
import com.ViewSideEffect
import com.ViewState
import com.model.Note


object NoteContract {
    data class NoteUiState(
        val noteList: List<Note> = emptyList(),
    ): ViewState

    sealed class NoteEvent: ViewEvent {
        data class NoteClicked(val id: Int): NoteEvent()
        object AddNote: NoteEvent()
    }

    sealed class NoteEffect: ViewSideEffect{
        sealed class Navigation : NoteEffect() {
            data class NavigateTo(val route: String): Navigation()
        }
    }


}
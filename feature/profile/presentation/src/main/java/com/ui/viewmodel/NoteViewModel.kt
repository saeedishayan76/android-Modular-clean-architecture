package com.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.BaseViewModel
import com.contract.NoteContract
import com.naviagtion.NoteScreens
import com.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val getNotesUseCase: GetNotesUseCase) :
    BaseViewModel<NoteContract.NoteEvent, NoteContract.NoteUiState,
            NoteContract.NoteEffect>() {
    override fun setInitialState(): NoteContract.NoteUiState = NoteContract.NoteUiState()

    init {
        getAllNotes()
    }

    private fun getAllNotes() {
        getNotesUseCase.invoke().onEach {
            setState {
                copy(noteList = it)
            }
        }.launchIn(viewModelScope)
    }

    override fun handleEvents(event: NoteContract.NoteEvent) {
        when (event) {
            is NoteContract.NoteEvent.NoteClicked -> {

            }

            is NoteContract.NoteEvent.AddNote -> setEffect { NoteContract.NoteEffect.Navigation.NavigateTo(NoteScreens.AddNoteScreen.route) }
        }
    }
}
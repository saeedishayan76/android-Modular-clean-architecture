package com.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.BaseViewModel
import com.Resource
import com.contract.AddNoteContract
import com.model.Note
import com.usecase.GetNotesUseCase
import com.usecase.InsertNoteUseCase
import com.util.InputWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val addNotesUseCase: InsertNoteUseCase) :
    BaseViewModel<AddNoteContract.AddNoteEvent, AddNoteContract.AddNoteState, AddNoteContract.AddNoteEffect>() {
    override fun setInitialState(): AddNoteContract.AddNoteState = AddNoteContract.AddNoteState()

    override fun handleEvents(event: AddNoteContract.AddNoteEvent) {
        when (event) {
            is AddNoteContract.AddNoteEvent.TitleTyped -> {
                setState {
                    copy(
                        titleValue = InputWrapper(
                            value = event.word,
                            errorMsg = if (event.word.length < 3) " please insert 3 character" else ""
                        )
                    )
                }
                setState { copy(isEnabledBtn = isBtnEnable()) }
            }

            is AddNoteContract.AddNoteEvent.BodyTyped -> {
                setState {
                    copy(
                        bodyValue = InputWrapper(
                            value = event.word,
                            errorMsg = if (event.word.length < 3) " please insert 3 character" else ""
                        )
                    )
                }
                setState { copy(isEnabledBtn = isBtnEnable()) }
            }

            is AddNoteContract.AddNoteEvent.AddButtonClick -> {
                addNotesUseCase.invoke(
                    Note(
                        title = viewState.value.titleValue.value,
                        body = viewState.value.bodyValue.value
                    )
                ).onEach {
                   when(it){
                       is Resource.Loading -> setState { copy(isLoading = true) }
                       is Resource.Success -> {
                           setState { copy(isLoading = false, successInserted = true)
                           }
                           setEffect { AddNoteContract.AddNoteEffect.showToast("Success Inserted") }
                       }
                       is Resource.Error -> setState { copy(isLoading = false, errorMsg = it.message) }
                   }
                }.launchIn(viewModelScope)
            }
        }
    }

    private fun isBtnEnable(): Boolean {
        return viewState.value.titleValue.value.length > 2 && viewState.value.bodyValue.value.length > 2
    }
}
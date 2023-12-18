package com.contract

import com.ViewEvent
import com.ViewSideEffect
import com.ViewState
import com.util.InputWrapper

object AddNoteContract {
    data class AddNoteState(
        val isLoading: Boolean = false,
        val successInserted: Boolean = false,
        val errorMsg: String = "",
        val titleValue: InputWrapper = InputWrapper("", ""),
        val bodyValue: InputWrapper = InputWrapper("", ""),
        val isEnabledBtn: Boolean = false
    ) : ViewState

    //intent
    sealed class AddNoteEvent: ViewEvent {
        data class TitleTyped(val word: String): AddNoteEvent()
        data class BodyTyped(val word: String): AddNoteEvent()
        object AddButtonClick: AddNoteEvent()

    }
    sealed class AddNoteEffect: ViewSideEffect {
        data class showToast(val value: String): AddNoteEffect()

    }
}
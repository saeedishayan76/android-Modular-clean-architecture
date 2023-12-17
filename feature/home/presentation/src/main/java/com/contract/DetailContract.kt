package com.contract

import com.ViewEvent
import com.ViewSideEffect
import com.ViewState
import com.model.User
import com.util.InputWrapper

object DetailContract {
    data class DetailUiState(
        val isLoading: Boolean = false,
        val user: User ?= null,
        val errorMsg: String = "",
        val userNameKey: InputWrapper = InputWrapper(),
        val passKey: InputWrapper = InputWrapper(),
        val isLoginEnabled: Boolean = false,

        ): ViewState

    sealed class DetailEvent :  ViewEvent{
    }

    sealed class DetailEffect : ViewSideEffect{

    }
}
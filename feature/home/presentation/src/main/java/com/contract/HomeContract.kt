package com.contract

import com.ViewEvent
import com.ViewSideEffect
import com.ViewState
import com.model.User

object HomeContract {
    data class HomeUiState(
        val isLoading: Boolean = false,
        val users: List<User> = emptyList(),
        val errorMsg: String = ""
    ) : ViewState

    sealed class HomeEffect : ViewSideEffect {
        sealed class Navigation : HomeEffect() {

            data class NavigateTo(val route:String) : Navigation()
        }
    }

    sealed class HomeEvent : ViewEvent {
        data class titleClicked(val user: User) : HomeEvent()
    }
}
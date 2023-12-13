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
            data class GoToDetail(val user: User) : Navigation()
            data class NavigateTo(val route:String) : Navigation()
            object GoToProfile : Navigation()
        }
    }

    sealed class HomeEvent : ViewEvent {
        data class titleClicked(val user: User) : HomeEvent()
        object fabProfileClicked: HomeEvent()
    }
}
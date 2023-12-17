package com.ui.home

import androidx.lifecycle.viewModelScope
import com.BaseViewModel
import com.contract.HomeContract
import com.navigation.HomeScreens
import com.usecase.UsersUseCase
import com.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userUseCase: UsersUseCase):
        BaseViewModel<HomeContract.HomeEvent, HomeContract.HomeUiState, HomeContract.HomeEffect>() {
    override fun setInitialState(): HomeContract.HomeUiState = HomeContract.HomeUiState()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        userUseCase.invoke().onEach {
            setState {
               when(it){
                   is Resource.Loading ->{
                       copy(isLoading = true)
                   }
                   is Resource.Success -> {
                       copy(isLoading = false, users = it.data)
                   }
                   is Resource.Error -> {
                       copy(isLoading = false, errorMsg = it.message)
                   }

               }
            }
        }.launchIn(viewModelScope)
    }

    override fun handleEvents(event: HomeContract.HomeEvent) {
        when(event){
            is HomeContract.HomeEvent.titleClicked -> setEffect {
                HomeContract.HomeEffect.Navigation.NavigateTo(HomeScreens.DetailScreen.route + "/${event.user.id}")}
        }
    }
}

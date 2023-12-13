package com

import androidx.lifecycle.viewModelScope
import com.contract.HomeContract
import com.navigation.HomeScreens
import com.usecase.GetUsersUseCase
import com.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getUsersUseCase: GetUsersUseCase):
        BaseViewModel<HomeContract.HomeEvent, HomeContract.HomeUiState, HomeContract.HomeEffect>() {
    override fun setInitialState(): HomeContract.HomeUiState = HomeContract.HomeUiState()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        getUsersUseCase.invoke().onEach {
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
            is HomeContract.HomeEvent.titleClicked -> setEffect { HomeContract.HomeEffect.Navigation.GoToDetail(user = event.user)}
            is HomeContract.HomeEvent.fabProfileClicked -> setEffect { HomeContract.HomeEffect.Navigation.GoToProfile }
        }
    }
}

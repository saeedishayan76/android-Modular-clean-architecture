package com.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BaseViewModel
import com.contract.DetailContract
import com.usecase.UsersUseCase
import com.util.InputWrapper
import com.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase,
    val savedStateHandle: SavedStateHandle
) :
    BaseViewModel<DetailContract.DetailEvent, DetailContract.DetailUiState, DetailContract.DetailEffect>() {

    init {
        savedStateHandle.get<Int>("id")?.let { fetchCurrentUser(it) }
    }
    fun fetchCurrentUser(id: Int) {
        usersUseCase.getUser(id).onEach {
            when (it) {
                is Resource.Loading -> setState {
                    copy(isLoading = true)
                }

                is Resource.Success -> {
                    setState {
                        copy(isLoading = false, user = it.data)
                    }
                }

                is Resource.Error -> {
                    setState {
                        copy(isLoading = false, errorMsg = it.message)
                    }
                }

            }
        }.launchIn(viewModelScope)
    }

    override fun setInitialState(): DetailContract.DetailUiState = DetailContract.DetailUiState()

    override fun handleEvents(event: DetailContract.DetailEvent) {
    }

}
package com.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.contract.DetailContract
import com.contract.HomeContract

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    id: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.viewState.value
    if (state.isLoading) {

        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Detail Screen Loading data ...")
        }
    }
    if (state.user != null) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp
                ), contentAlignment = Alignment.Center
        ) {
            Text(text = "Detail Screen ${state.user.title}")
        }
    }

    if (state.errorMsg.isNotEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Detail Screen Error${state.errorMsg}")
        }
    }


}
package com.ui.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.contract.HomeContract
import com.model.User

private const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateTo: (String) -> Unit
) {
    val state = viewModel.viewState.value

    LaunchedEffect(key1 = Unit) {
        viewModel.effect.collect {
            when (it) {
                is HomeContract.HomeEffect.Navigation.NavigateTo -> navigateTo(it.route)
            }
        }
    }

    if (state.isLoading) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Home Page Loading Users ...", modifier.clickable {
                // viewModel.setEvent(HomeContract.HomeEvent.titleClicked)
            })
        }
    }

    if (state.users.isNotEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.users.subList(0, 22)) { user ->
                    UserItem(user) {
                        viewModel.setEvent(HomeContract.HomeEvent.titleClicked(user))
                    }
                }
            }
        }
    }
    if (state.errorMsg.isNotEmpty()) {
        Log.i(TAG, "HomeScreen: Users fetched   error${state.errorMsg} ")
    }


}

@Composable
fun UserItem(
    user: User,
    onUserClicked: () -> Unit
) {
    Text(
        text = user.title,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onUserClicked.invoke()
            },
        textAlign = TextAlign.Center,
        color = Color.Black,
        fontSize = 18.sp
    )
}

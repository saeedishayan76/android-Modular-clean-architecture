package com.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.contract.AddNoteContract
import com.ui.viewmodel.AddNoteViewModel
import com.ui.viewmodel.NoteViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun AddNoteScreen(
    modifier: Modifier = Modifier,
    viewModel: AddNoteViewModel = hiltViewModel(),
    onSuccessInsert: () -> Unit
) {
    val state = viewModel.viewState.value

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading) {
            LinearProgressIndicator()
        }

        val context = LocalContext.current
        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collect {
                when (it) {
                    is AddNoteContract.AddNoteEffect.showToast -> {
                        Toast.makeText(
                            context,
                            it.value,
                            Toast.LENGTH_SHORT
                        ).show()
                        onSuccessInsert.invoke()
                    }


                }
            }
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            singleLine = true
            ,value = state.titleValue.value,
            onValueChange = {
                viewModel.setEvent(AddNoteContract.AddNoteEvent.TitleTyped(it))
            }
        )
        Text(text = state.titleValue.errorMsg)
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            value = state.bodyValue.value,
            singleLine = true,
            onValueChange = {
                viewModel.setEvent(AddNoteContract.AddNoteEvent.BodyTyped(it))
            },
            label = {

            }
        )
        Text(text = state.bodyValue.errorMsg)

        Button(onClick = {
            viewModel.setEvent(AddNoteContract.AddNoteEvent.AddButtonClick)
        }, enabled = state.isEnabledBtn) {
            Text(text = "Add This Note")
        }
    }
}
package com.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.contract.NoteContract
import com.model.Note
import com.ui.viewmodel.NoteViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel = hiltViewModel(),
    onAddNoteClick: (String) -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize(),
    ) {

        val state = viewModel.viewState.value
        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collect {
                when (it) {
                    is NoteContract.NoteEffect.Navigation.NavigateTo -> onAddNoteClick.invoke(it.route)
                }
            }
        }
        if (state.noteList.isEmpty()) {
            Text(text = "Profile Screen empty note")
            Spacer(modifier = modifier.size(16.dp))

        } else {
            LazyColumn(
                modifier = modifier
                    .padding(16.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.noteList) { note ->
                    NoteItem(note) {
                        viewModel.setEvent(NoteContract.NoteEvent.NoteClicked(note.id))
                    }
                }
            }

        }

        Button(modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
            onClick = {
                viewModel.setEvent(NoteContract.NoteEvent.AddNote)
            }) {
            Text(text = "Add Note")
        }

    }
}

@Composable
fun NoteItem(
    note: Note,
    onNoteClick: (Note) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onNoteClick.invoke(note)
            }, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = note.title)
        Text(text = note.body, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}

package com.repositry

import com.model.Note
import com.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNote(): Flow<List<Note>>

    fun insertNote(note: Note): Flow<Resource<Unit>>
}
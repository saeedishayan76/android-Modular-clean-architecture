package com.usecase

import com.model.Note
import com.repositry.NoteRepository
import com.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    operator fun invoke(note: Note): Flow<Resource<Unit>> {
        return noteRepository.insertNote(note)
    }
}
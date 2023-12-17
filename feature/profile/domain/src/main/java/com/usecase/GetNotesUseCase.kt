package com.usecase

import com.model.Note
import com.repositry.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getAllNote()
    }
}
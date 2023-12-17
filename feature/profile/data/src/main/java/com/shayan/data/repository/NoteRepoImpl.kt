package com.shayan.data.repository

import com.model.Note
import com.repositry.NoteRepository
import com.shayan.data.Mapper.toNote
import com.shayan.database.dao.NoteDao
import com.shayan.database.entity.NoteEntity
import com.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteRepoImpl (private val noteDao: NoteDao): NoteRepository {
    override fun getAllNote(): Flow<List<Note>>  = flow{
      noteDao.getAllNotes().collect { noteEntity ->
            emit(noteEntity.map { it.toNote() })
      }
    }

    override fun insertNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading)
        try {
            noteDao.insertNote(noteEntity = NoteEntity(title = note.title, body = note.body))
            emit(Resource.Success(data = Unit))

        }catch (e: Exception){
            emit(Resource.Error(message = e.localizedMessage ?: "error in insert"))
        }
    }

}
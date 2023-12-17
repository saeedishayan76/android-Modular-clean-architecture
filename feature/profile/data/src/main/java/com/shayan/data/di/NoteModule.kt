package com.shayan.data.di

import com.repositry.NoteRepository
import com.shayan.data.repository.NoteRepoImpl
import com.shayan.database.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    fun provideNoteRepository(noteDao: NoteDao):NoteRepository {
        return NoteRepoImpl(noteDao)
    }
}
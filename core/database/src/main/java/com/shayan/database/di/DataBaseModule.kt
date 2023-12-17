package com.shayan.database.di

import android.content.Context
import androidx.room.Room
import com.shayan.database.AppDataBase
import com.shayan.database.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "clean-database")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideNoteDao(appDataBase: AppDataBase): NoteDao = appDataBase.noteDao()


}
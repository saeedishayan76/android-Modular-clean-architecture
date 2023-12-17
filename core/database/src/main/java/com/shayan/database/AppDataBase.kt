package com.shayan.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shayan.database.dao.NoteDao
import com.shayan.database.entity.NoteEntity

@Database(entities = [NoteEntity::class], exportSchema = false, version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
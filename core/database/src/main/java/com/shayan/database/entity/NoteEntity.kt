package com.shayan.database.entity

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val body: String
)



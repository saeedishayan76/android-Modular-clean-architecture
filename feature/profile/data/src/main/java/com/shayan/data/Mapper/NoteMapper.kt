package com.shayan.data.Mapper

import com.model.Note
import com.shayan.database.entity.NoteEntity

fun NoteEntity.toNote(): Note {
    return Note(
        title = title,
        body = body
    )
}
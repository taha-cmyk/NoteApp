package com.example.selfmd.data.databases.local.util

import com.example.selfmd.data.databases.local.NoteEntity
import com.example.selfmd.data.notes.models.Note

object NoteMapper {
    fun toEntity(note: Note): NoteEntity {
        return NoteEntity(
            id = note.id,
            title = note.title,
            content = note.content,
            isFavorite = note.isFavorite

        )
    }

    fun toModel(entity: NoteEntity): Note {
        return Note(
            id = entity.id,
            title = entity.title,
            content = entity.content,
            isFavorite = entity.isFavorite
        )
    }
}

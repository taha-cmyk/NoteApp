package com.example.selfmd.data.notes.repository

import com.example.selfmd.data.notes.models.Note

interface INoteRepository {

    fun getAllNotesStream(): List<Note>

    fun getNoteStream(id: Long): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun updateNote(note: Note)
    suspend fun getFavoriteNotes():List<Note>
}
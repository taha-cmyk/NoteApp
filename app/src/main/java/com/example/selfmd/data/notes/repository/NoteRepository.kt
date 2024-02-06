package com.example.selfmd.data.notes.repository

import com.example.selfmd.data.notes.models.Note
import kotlinx.coroutines.flow.Flow

interface INoteRepository {

    fun getAllNotesStream(): Flow<List<Note>>

    fun getNoteStream(id: Int): Flow<Note?>

    suspend fun insertNote(Note: Note)

    suspend fun deleteNote(Note: Note)

    suspend fun updateNote(Note: Note)
}
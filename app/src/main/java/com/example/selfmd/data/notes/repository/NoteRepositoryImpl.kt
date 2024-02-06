package com.example.selfmd.data.notes.repository

import com.example.selfmd.data.notes.models.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl : INoteRepository {
    override fun getAllNotesStream(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getNoteStream(id: Int): Flow<Note?> {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(Note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(Note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(Note: Note) {
        TODO("Not yet implemented")
    }
}
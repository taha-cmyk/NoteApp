package com.example.selfmd.data.notes.repository

import com.example.selfmd.data.databases.local.NoteDao
import com.example.selfmd.data.notes.models.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class OfflineNoteRepository @Inject constructor(private val noteDao: NoteDao):INoteRepository {

    override fun getAllNotesStream(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override fun getNoteStream(id: Int): Flow<Note?> {
        return noteDao.getNote(id)
    }

    override suspend fun insertNote(Note: Note) {
        return noteDao.insert(Note)
    }

    override suspend fun deleteNote(Note: Note) {
        return noteDao.delete(Note)
    }

    override suspend fun updateNote(Note: Note) {
        return noteDao.update(Note)
    }
}
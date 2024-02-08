package com.example.selfmd.data.notes.repository

import com.example.selfmd.data.databases.local.NoteDao
import com.example.selfmd.data.databases.local.util.NoteMapper
import com.example.selfmd.data.notes.models.Note
import javax.inject.Inject


class OfflineNoteRepository @Inject constructor(private val noteDao: NoteDao):INoteRepository {

    override fun getAllNotesStream(): List<Note> {
        val noteEntities = noteDao.getAll()
        return noteEntities.map { NoteMapper.toModel(it) }
    }

    override fun getNoteStream(id: Long): Note? {
        val noteEntity = noteDao.getById(id)
        return noteEntity?.let { NoteMapper.toModel(it) }
    }

    override suspend fun insertNote(note: Note) {
        val noteEntity = NoteMapper.toEntity(note)
        noteDao.insert(noteEntity)
    }

    override suspend fun deleteNote(note: Note) {
        val noteEntity = NoteMapper.toEntity(note)
        noteDao.delete(noteEntity)
    }

    override suspend fun updateNote(note: Note) {
        val noteEntity = NoteMapper.toEntity(note)
        noteDao.update(noteEntity)
    }

    override suspend fun getFavoriteNotes(): List<Note> {
        val noteEntities = noteDao.getFavoriteNotes()
        return noteEntities.map { NoteMapper.toModel(it) }
    }
}
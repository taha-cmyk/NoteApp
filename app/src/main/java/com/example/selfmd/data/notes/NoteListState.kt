package com.example.selfmd.data.notes

import com.example.selfmd.data.notes.models.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false
    )


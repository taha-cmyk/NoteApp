package com.example.selfmd.data.notes

import java.util.Date

data class CreateNoteState(
    val title: String = "Note ${Date().toString()}",
    val content: String = "",
    val isLoading: Boolean = false,
    val isReadingMode: Boolean = false
)

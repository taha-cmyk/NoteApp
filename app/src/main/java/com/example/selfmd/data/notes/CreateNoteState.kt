package com.example.selfmd.data.notes

import java.text.DateFormat

data class CreateNoteState(
    val title: String = "Note ${DateFormat.DATE_FIELD}",
    val content: String = "",
    val isLoading: Boolean = false,
    val isReadingMode: Boolean = false
)

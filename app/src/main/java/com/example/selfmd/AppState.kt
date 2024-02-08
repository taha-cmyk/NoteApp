package com.example.selfmd

import com.example.selfmd.data.notes.models.Note

data class AppState(
    val notes: List<Note>,
    val theme: Theme = Theme.LIGHT,
    val font: Font = Font.DEFAULT,
    val fontSize: FontSize = FontSize.MEDIUM,
    val isLoading: Boolean = false
)


enum class Theme {
    LIGHT, DARK
}

enum class Font {
    DEFAULT, ROBOTO, OPEN_SANS
}

enum class FontSize {
    SMALL, MEDIUM, LARGE
}

package com.example.selfmd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.selfmd.data.notes.repository.INoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(
    private val userPreference: UserPreference,
    private val note_repo : INoteRepository

) : ViewModel() {

    private val _appState = MutableStateFlow(AppState(notes = emptyList()))
    val appState: StateFlow<AppState> = _appState
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val notes = note_repo.getAllNotesStream()
            _appState.value = AppState(
                notes = notes,
                theme = Theme.LIGHT,
                font = Font.DEFAULT,
                fontSize = FontSize.MEDIUM
            )
        }
    }

    fun refresh() {
        _appState.value = _appState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            //Thread.sleep(2000)
            val notes = note_repo.getAllNotesStream()
            _appState.value = _appState.value.copy(notes = notes,isLoading = false)
        }
    }

    fun getFavorites() {
        _appState.value = _appState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            //Thread.sleep(2000)
            val notes = note_repo.getFavoriteNotes()
            _appState.value = _appState.value.copy(notes = notes,isLoading = false)
        }
    }


    fun updateTheme(theme: Theme) {
        viewModelScope.launch {
            userPreference.saveUserTheme(theme.toString())
            _appState.value = _appState.value.copy(theme = theme)
        }
    }

    fun updateFont(font: Font) {
        viewModelScope.launch {
            userPreference.saveUserFont(font.toString())
            _appState.value = _appState.value.copy(font = font)

        }
    }

    fun updateFontSize(fontSize: FontSize) {
        _appState.value = _appState.value.copy(fontSize = fontSize)
    }

     fun updateNoteIsFavorite(noteId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val note = note_repo.getNoteStream(noteId)
            note?.let {
                it.isFavorite = !it.isFavorite
                note_repo.updateNote(it)
                refresh()
            }
        }
    }



}
package com.example.selfmd.data.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.selfmd.data.notes.models.Note
import com.example.selfmd.data.notes.repository.OfflineNoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val note_repo : OfflineNoteRepository

) : ViewModel(){

    private val _uiState = MutableStateFlow<NoteListState>(NoteListState())
    val uiState = _uiState.asStateFlow()
    
    fun getAllNotes() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val notes = note_repo.getAllNotesStream()
            _uiState.value = _uiState.value.copy(notes = notes,isLoading = false)
        }
    }


     fun upsertNote(note: Note){
         _uiState.value = _uiState.value.copy(isLoading = true)
         viewModelScope.launch(Dispatchers.IO) {
             val notes = note_repo.insertNote(note)
             _uiState.value = _uiState.value.copy(isLoading = false)
         }
    }

     fun deleteNote(note: Note){
         _uiState.value = _uiState.value.copy(isLoading = true)
         viewModelScope.launch(Dispatchers.IO) {
             val notes = note_repo.deleteNote(note)
             _uiState.value = _uiState.value.copy(isLoading = false)
         }
    }

    suspend fun updateNote(note: Note){
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val notes = note_repo.updateNote(note)
            _uiState.value = _uiState.value.copy(isLoading = false)
        }
    }



}
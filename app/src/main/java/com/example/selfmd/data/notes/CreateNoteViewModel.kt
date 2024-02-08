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
class CreateNoteViewModel @Inject constructor(
    private val note_repo : OfflineNoteRepository

) : ViewModel(){

    private val _uiState = MutableStateFlow<CreateNoteState>(CreateNoteState())
    val uiState = _uiState.asStateFlow()

    fun setContent(content:String){
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(content = content)
        }
    }

    fun setTitle(title:String){
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(title = title)
        }
    }

    fun setReadingMode(mode:Boolean){
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isReadingMode = mode)
        }
    }
    fun insertNote(note: Note){
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            note_repo.insertNote(note)
            _uiState.value = _uiState.value.copy(isLoading = false)
        }
    }

     fun updateNote(note: Note){
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
             note_repo.updateNote(note)
            _uiState.value = _uiState.value.copy(isLoading = false)
        }
    }

    fun getNote(id:Long){
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val note = note_repo.getNoteStream(id)
            if (note != null) {
                _uiState.value.copy(content = note.content, title = note.title)
                    .also { _uiState.value = it }
            }
        }
    }



}
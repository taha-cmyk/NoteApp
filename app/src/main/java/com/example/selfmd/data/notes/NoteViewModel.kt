package com.example.selfmd.data.notes

import androidx.lifecycle.ViewModel
import com.example.selfmd.data.notes.repository.INoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val note_repo : INoteRepository

) : ViewModel(){

    fun getAll():String {
        return "Helloooooo"
    }

    fun to_String():String{
        return note_repo.toString()
    }

}
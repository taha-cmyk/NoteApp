package com.example.selfmd.presentation.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.selfmd.data.notes.CreateNoteViewModel

@Composable
fun NoteEditor(
    viewModel: CreateNoteViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

    Column {

        BasicTextField(
            readOnly = uiState.isReadingMode,
            modifier = Modifier.fillMaxSize(),
            value = uiState.content,
            onValueChange ={
            viewModel.setContent(it)
        }) { innerTextField ->
            innerTextField()
        }
    }

}



package com.example.selfmd.presentation.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.selfmd.data.notes.CreateNoteViewModel

@Composable
fun NoteEditor(
    viewModel: CreateNoteViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

    Column {

        BasicTextField(
            textStyle= TextStyle(fontSize = 20.sp),
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



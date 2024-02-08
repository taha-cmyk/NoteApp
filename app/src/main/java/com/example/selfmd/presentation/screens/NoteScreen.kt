package com.example.selfmd.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.selfmd.data.notes.CreateNoteState
import com.example.selfmd.data.notes.CreateNoteViewModel
import com.example.selfmd.data.notes.models.Note
import com.example.selfmd.navigation.AppScreens
import com.example.selfmd.presentation.notes.NoteEditor

@Composable
fun EditorScreen(
    navHostController: NavHostController,
    viewModel: CreateNoteViewModel,
    noteId: Long
) {
    val noteState by viewModel.uiState.collectAsState()
    val context = LocalContext.current


    Column {
        EditorTopBar(
            onBackClicked = {navHostController.navigate(AppScreens.Home.route)},
            onSaveClicked = {
            if (noteId == 0L){
                Toast.makeText(context, "Note Created ", Toast.LENGTH_SHORT).show()
                viewModel.insertNote(Note(title = noteState.title, content = noteState.content))
            } else
            {
                Toast.makeText(context, "Note Updated ", Toast.LENGTH_SHORT).show()
                viewModel.updateNote(Note(title = noteState.title, content = noteState.content))

            }
             },
            onToggleReadingModeClicked = {viewModel.setReadingMode(!noteState.isReadingMode)},
            noteState = noteState)

        if (noteId != 0L){
            viewModel.getNote(noteId)
        }



        TextField(
            readOnly = noteState.isReadingMode,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true, value = noteState.title,
            onValueChange ={ viewModel.setTitle(it)} )

        NoteEditor(viewModel=viewModel)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorTopBar(
    onBackClicked : ()->Unit,
    onSaveClicked: ()->Unit,
    onToggleReadingModeClicked: ()->Unit,
    noteState:CreateNoteState
) {
    TopAppBar(
        title = {
        },
        actions = {

                val background = if(noteState.isReadingMode) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.background
                IconButton(
                    modifier = Modifier.background(background).clip(RoundedCornerShape(20)),
                    onClick = { onToggleReadingModeClicked() }) {
                    Icon(imageVector = Icons.Default.Create, contentDescription = null)
                }

                IconButton(
                    enabled = !noteState.isReadingMode,
                    onClick = { onSaveClicked() }) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = null)
                }



        },
        navigationIcon = {

            IconButton(onClick = { onBackClicked() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },

        )
}
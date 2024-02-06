package com.example.selfmd.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.example.selfmd.navigation.AppScreens
import com.example.selfmd.presentation.notes.NoteEditor
import com.example.selfmd.presentation.shared.components.ScafforldLayout
import com.example.selfmd.presentation.shared.components.TopBar

@Composable
fun EditorScreen(navHostController: NavHostController) {
    ScafforldLayout(topBar = {  EditorTopBar(onBackClicked = {navHostController.navigate(AppScreens.Home.route)}, onSaveClicked = {}) }) {
        NoteEditor()
    }
}

@Composable
fun EditorTopBar(onBackClicked : ()->Unit,onSaveClicked: ()->Unit) {
    TopBar(
        title = {
            Text(
                text = "New Note" ,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = {onBackClicked() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { onSaveClicked() }) {
                Icon(imageVector = Icons.Default.Done, contentDescription =null )
            }
        }

    )
}
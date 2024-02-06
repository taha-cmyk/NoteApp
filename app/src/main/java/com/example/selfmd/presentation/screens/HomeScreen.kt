package com.example.selfmd.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.example.selfmd.data.notes.NoteViewModel
import com.example.selfmd.navigation.AppScreens
import com.example.selfmd.presentation.shared.components.FloatingActionButtonContent
import com.example.selfmd.presentation.shared.components.ScafforldLayout
import com.example.selfmd.presentation.shared.components.TopBar

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: NoteViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    ScafforldLayout(
        topBar = { HomeTopBar(onSettingsClicked = {navHostController.navigate(AppScreens.Settings.route)}) },
        floatingActionButton = { HomefloatingActionButton(onClick = {navHostController.navigate(AppScreens.Editor.route)}) }
    )
    {
        val repo: String =  viewModel.to_String()

        Text(text = "$repo")

    }
}


@Composable
fun HomeTopBar(onSettingsClicked : ()->Unit) {
    TopBar(
        title = {
            Text(
                text = "Home" ,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        ,
        actions = {
            IconButton(onClick = { onSettingsClicked() }) {
                Icon(imageVector = Icons.Default.Settings, contentDescription =null )
            }
        }
    )
}

@Composable
fun HomefloatingActionButton(onClick: ()->Unit) {
    FloatingActionButtonContent {
        FloatingActionButton(onClick = { onClick() }) {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
        }
    }
}



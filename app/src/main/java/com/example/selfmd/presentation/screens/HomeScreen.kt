package com.example.selfmd.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.selfmd.AppViewModel
import com.example.selfmd.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: AppViewModel
) {

    val appState by viewModel.appState.collectAsState()


    Column {
        HomeTopBar(
            onSettingsClicked = { navHostController.navigate(AppScreens.Settings.route) },
            onAddClicked = {navHostController.navigate(AppScreens.Editor.route)},
            onRefreshClicked = {viewModel.refresh()}
        )
        if(appState.isLoading) LinearProgressIndicator(modifier = Modifier.fillMaxWidth())

        Row {
            TextButton(onClick = { viewModel.refresh() }) {
                Text(text = "All")
            }
            TextButton(onClick = { viewModel.getFavorites() }) {
                Text(text = "Favorite")
            }

        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            itemsIndexed(appState.notes) { index, note ->
                val content = if (note.content.length > 200) "${note.content.substring(0, 200)} more ..." else note.content
                val title = if (note.title.length > 20) "${note.title.substring(0, 20)} ..." else note.title
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp),
                    onClick = {
                        navHostController.navigate("editor?noteId=${note.id}")
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = title, fontSize = 25.sp)

                            IconButton(onClick = {
                                viewModel.updateNoteIsFavorite(note.id)
                            }) {
                                Icon(imageVector = if (note.isFavorite) {
                                    Icons.Rounded.Favorite
                                } else Icons.Rounded.FavoriteBorder , contentDescription = null)
                            }
                        }
                        Text(text = content)
                    }
                }
            }
        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onSettingsClicked : ()->Unit,onAddClicked : ()->Unit,onRefreshClicked:()->Unit) {
    TopAppBar(title = {
        Text(text = "Home")
    },
        actions = {
            IconButton(onClick = { onRefreshClicked() }) {
                Icon(imageVector = Icons.Rounded.Refresh, contentDescription = null)
            }
            IconButton(onClick = { onSettingsClicked() }) {
                Icon(imageVector = Icons.Rounded.Settings, contentDescription = null)
            }

            IconButton(onClick = { onAddClicked() }) {
                Icon(imageVector = Icons.Rounded.AddCircle, contentDescription = null)
            }

        })
}





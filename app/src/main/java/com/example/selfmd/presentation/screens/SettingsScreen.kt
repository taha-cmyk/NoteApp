package com.example.selfmd.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.example.selfmd.AppViewModel
import com.example.selfmd.navigation.AppScreens
import com.example.selfmd.presentation.shared.components.ScafforldLayout
import com.example.selfmd.presentation.shared.components.TopBar


@Composable
fun SettingsSreen(
    navHostController: NavHostController,
    viewModel: AppViewModel

) {
    ScafforldLayout(
        topBar = { SettingsTopBar(onBackClicked = {navHostController.navigate(AppScreens.Home.route)}) },

    )
    {

    }

}


@Composable
fun SettingsTopBar(onBackClicked : ()->Unit) {
    TopBar(
        title = {
            Text(
                text = "Settings" ,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = {onBackClicked() }) {
               Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }

    )
}


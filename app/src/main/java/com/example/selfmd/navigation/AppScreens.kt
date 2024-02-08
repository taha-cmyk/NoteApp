package com.example.selfmd.navigation

sealed class AppScreens (val route : String){
    object Home : AppScreens("home")
    object Settings : AppScreens("settings")
    object Editor : AppScreens("editor?noteId={noteId}")
}
package com.example.selfmd.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.selfmd.presentation.screens.EditorScreen
import com.example.selfmd.presentation.screens.HomeScreen
import com.example.selfmd.presentation.screens.SettingsSreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController,
            startDestination = AppScreens.Home.route
    ){

        composable(route=AppScreens.Home.route){
            HomeScreen(navHostController = navController)
        }

        composable(route=AppScreens.Settings.route){
            SettingsSreen(navHostController = navController)
        }

        composable(route=AppScreens.Editor.route){
            EditorScreen(navHostController = navController)
        }



    }
}
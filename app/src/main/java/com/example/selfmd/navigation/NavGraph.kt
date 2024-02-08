package com.example.selfmd.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.selfmd.presentation.screens.EditorScreen
import com.example.selfmd.presentation.screens.HomeScreen
import com.example.selfmd.presentation.screens.SettingsSreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController,
            startDestination = AppScreens.Home.route
    ){

        composable(route=AppScreens.Home.route){
            HomeScreen(navHostController = navController, viewModel = hiltViewModel())
        }

        composable(route=AppScreens.Settings.route){
            SettingsSreen(navHostController = navController, viewModel = hiltViewModel())
        }

        composable(
            route=AppScreens.Editor.route,
            arguments = listOf(navArgument("noteId") { defaultValue=0L;type = NavType.LongType })
            ){backStackEntry ->
            val noteId = backStackEntry.arguments?.getLong("noteId") ?: 0L
            EditorScreen(
                    navHostController = navController,
                    viewModel = hiltViewModel(),
                    noteId = noteId
                    )
        }



    }
}
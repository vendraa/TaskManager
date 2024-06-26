package com.example.taskmanager

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taskmanager.main.MainScreen
import com.example.taskmanager.navigation.Screens
import com.example.taskmanager.notes.addNoteScreen
import com.example.taskmanager.tasks.addTaskScreen

@Composable
fun MainNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screens.Main.route) {
        composable(Screens.Main.route) { MainScreen(navController = navController) }
        addTaskScreen(
            navController = navController,
            onNavigationBack = { navController.navigateUp() }
        )
        addNoteScreen(
            navController = navController,
            onNavigationBack = { navController.navigateUp() }
        )
    }
}
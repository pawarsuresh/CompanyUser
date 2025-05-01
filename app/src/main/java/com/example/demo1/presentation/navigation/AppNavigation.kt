package com.example.demo1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo1.presentation.screen.CatScreen
import com.example.demo1.presentation.screen.HomeScreen
import com.example.demo1.presentation.screen.TopAppBarSetup
import com.example.demo1.presentation.screen.UserDetailScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
            composable(route = Screen.CatDetail.route) {
                CatScreen() }

            composable(Screen.UserList.route) {
                TopAppBarSetup(navController = navController) }

            composable(route = Screen.UserDetail.route) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("userId")
                UserDetailScreen(
                    userid = id.toString()
                )
        }
    }
}

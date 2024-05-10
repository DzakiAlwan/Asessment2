package org.d3if3096.assesment2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.d3if3096.assesment2.ui.theme.screen.DetailScreen
import org.d3if3096.assesment2.ui.theme.screen.KEY_ID_MOTOR
import org.d3if3096.assesment2.ui.theme.screen.MainScreen

@Composable
fun SetUpNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController ,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            MainScreen(navController)
        }
        composable(
            route = Screen.FormBaru.route
        ){
            DetailScreen(navController)
        }
        composable(
            route = Screen.FormUbah.route,
            arguments = listOf(
                navArgument(KEY_ID_MOTOR) {type = NavType.LongType}
            )
        ){ navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_MOTOR)
            DetailScreen(navController,id)
        }
    }
}
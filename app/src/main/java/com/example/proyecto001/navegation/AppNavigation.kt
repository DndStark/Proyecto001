package com.example.proyecto001.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyecto001.components.GroupsActivity
import com.example.proyecto001.components.FormActivity

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.GroupsActivity.route){
        composable(route = AppScreens.GroupsActivity.route){
            GroupsActivity(navController, it.arguments?.getString("usuario"))
        }
        composable(route = AppScreens.FormActivity.route + "/{grupo}",
            arguments = listOf(navArgument(name = "grupo"){
                type = NavType.StringType
            })){
            FormActivity(navController, it.arguments?.getString("grupo"))
        }
    }

}
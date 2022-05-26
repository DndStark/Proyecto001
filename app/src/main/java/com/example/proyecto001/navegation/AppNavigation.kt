package com.example.proyecto001.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyecto001.componentes.GroupsActivity
import com.example.proyecto001.componentes.LoginActivity
import com.example.proyecto001.componentes.FormActivity

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginActivity.route){
        composable(route = AppScreens.LoginActivity.route){
            LoginActivity(navController)
        }
        composable(route = AppScreens.GroupsActivity.route + "/{usuario}",
            arguments = listOf(navArgument(name = "usuario"){
                type = NavType.StringType
            })){
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
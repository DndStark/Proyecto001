package com.example.proyecto001.navegation

sealed class AppScreens(val route: String){
    object LoginActivity: AppScreens("firts_screen")
    object GroupsActivity: AppScreens("second_screen")
    object FormActivity: AppScreens("thirt_screen")
}

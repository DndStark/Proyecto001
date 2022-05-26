package com.example.proyecto001

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.proyecto001.navegation.AppNavigation
import com.example.proyecto001.ui.theme.Proyecto001Theme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email", "Mmmm@gmail.com")
        prefs.putString("name", "Miguel mmmm")
        prefs.apply()

        setContent {
            Proyecto001Theme {
                AppNavigation()
            }
        }
    }

    fun LogOut(email: String){
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.clear()
        prefs.apply()
    }
}
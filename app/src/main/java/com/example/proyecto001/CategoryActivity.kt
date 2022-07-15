package com.example.proyecto001

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.proyecto001.components.CategoriesList
import com.example.proyecto001.firebase.MyFirebaseMessagingService
import com.example.proyecto001.ui.theme.Proyecto001Theme

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val counter: String? = intent.getStringExtra("counter")

        val preferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val mail: String? = preferences.getString("email", null)
        val name: String? = preferences.getString("name", null)
        val token: String? = preferences.getString("token", null)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " Category Activity " + mail)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " Category Activity " + name)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " Category Activity " + token)

        setContent {
            Proyecto001Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CategoriesList(counter, this@CategoryActivity)
                }
            }
        }
    }
}


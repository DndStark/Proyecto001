package com.example.proyecto001

<<<<<<< HEAD
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
=======
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.proyecto001.components.CategoriesList
import com.example.proyecto001.components.CategoryLeftNav
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
import com.example.proyecto001.ui.theme.Proyecto001Theme

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val counter: String? = intent.getStringExtra("counter")

<<<<<<< HEAD
        val preferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val mail: String? = preferences.getString("email", null)
        val name: String? = preferences.getString("name", null)
        val token: String? = preferences.getString("token", null)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " Category Activity " + mail)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " Category Activity " + name)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " Category Activity " + token)

=======
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        setContent {
            Proyecto001Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
<<<<<<< HEAD
                    CategoriesList(counter, this@CategoryActivity)
=======
                    CategoriesList(counter)
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
                }
            }
        }
    }
}


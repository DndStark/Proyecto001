package com.example.proyecto001

import android.content.Context
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.proyecto001.database.preferences.SettingsManager
import com.example.proyecto001.firebase.MyFirebaseMessagingService
import com.example.proyecto001.ui.theme.Proyecto001Theme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
<<<<<<< HEAD
import com.google.firebase.firestore.FirebaseFirestore
=======
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
<<<<<<< HEAD
    //Código para nuestra autenticación
    private val GOOGLE_SIGN_IN = 1000
    //Conexión a Firebase
    private lateinit var  firebaseAuth: FirebaseAuth
    //Conexión a Firebase Google Auth
    private lateinit var googleSignIngClient: GoogleSignInClient
    //Conexión a Jetpack Datastore
    private lateinit var settingManager: SettingsManager
    //Intent general para dirigirnos a una segunda actividad
    private lateinit var intentTo: Intent
    //Conexión a Cloud Firestore
    private val dbFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
=======
    private val GOOGLE_SIGN_IN = 1000
    private lateinit var  firebaseAuth: FirebaseAuth
    private lateinit var googleSignIngClient: GoogleSignInClient

    private lateinit var settingManager: SettingsManager

    private lateinit var intentTo: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "create")
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        //notification()

        setContent {
            Proyecto001Theme {
                firebaseAuth = FirebaseAuth.getInstance()
                Login()
            }
        }
    }

    private fun manageCounter(){
<<<<<<< HEAD
=======
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "manageCounter" )
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        settingManager = SettingsManager(applicationContext)
        var counterValue = ""

        lifecycleScope.launch {
            settingManager.incrementCounter()
            settingManager.counter.collect{counter ->
                counterValue = counter.toString()
                counterValue?.let {
<<<<<<< HEAD
                    intentTo = Intent(this@MainActivity, CategoryActivity::class.java)
=======
                    intentTo = Intent(this@MainActivity, ItemsActivity::class.java)
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
                    intentTo.putExtra("counter", counterValue)
                    startActivity(intentTo)
                }
            }
        }
    }

    private fun notification() {
        val m: String? = intent.getStringExtra("message")
        val u: String? = intent.getStringExtra("url")
        m?.let {
            val intent = Intent(this, FirstActivity::class.java)
            intent.putExtra("message", m)
            intent.putExtra("url", u)
            startActivity(intent)
        }

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener{ task ->
                if (task.isSuccessful){
                    Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "notification" + task.result)
                }
            }
    }

    override fun onStart() {
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "onStart")
        if(VerifyLastLogin()){
            setContent {
                Proyecto001Theme {
                    manageCounter()
                }
            }
        }
        super.onStart()
    }

    fun LogOut(email: String){
        val preferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        preferences.clear()
        preferences.apply()
    }

    fun imprimir(s: String){
        Toast.makeText(this@MainActivity, "Este es un mensaje - ${s}", Toast.LENGTH_LONG).show()
    }

<<<<<<< HEAD
    fun saveCredentials(mail: String, name: String){
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "maillllllllllllll" + mail)
        // Guardando datos de inicio de sesión
=======
    fun saveCredentials(name: String, mail: String){
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "saveCredentials")
        // Guardando datosde inicio de sesión
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        val preferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        preferences.putString("email", mail)
        preferences.putString("name", name)
        preferences.apply()
<<<<<<< HEAD

        val preferencesGet = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val token: String? = preferencesGet.getString("token", null)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " tokennn " + token)
        saveCredentialsFirestore(mail, name, token!!)
    }

    fun saveCredentialsFirestore(mail: String, name: String, token: String){
        // Guardando datos de inicio de sesión en Cloud Firestore
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "mail" + mail)
        dbFirestore.collection("users").document(mail).set(
            hashMapOf("name" to name, "token" to token)
        )
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "name" + name)
=======
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
    }

    fun VerifyLastLogin(): Boolean {
        // Guardando datosde inicio de sesión
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "VerifyLastLogin")
        val preferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val mail: String? = preferences.getString("email", null)
        Toast.makeText(this, "start ${mail}",Toast.LENGTH_LONG).show()
        return mail != null
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

<<<<<<< HEAD
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " Verify token shared")
        val preferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val tk: String? = preferences.getString("token", null)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " ttt " + tk)

=======
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!

                if(account!=null){
<<<<<<< HEAD
=======
                    Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "onActivityResult")
                    Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " /////////////" + account.idToken)
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
                    firebaseAuthWithGoogle(account.idToken!!)
                }else{
                    Toast.makeText(this, "Su correo no existe",Toast.LENGTH_LONG).show()
                }
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, "Error al ingresar "+e.toString(), Toast.LENGTH_SHORT)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
<<<<<<< HEAD
=======
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + idToken)
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + "FirebaseAuthWithGoogle")
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = firebaseAuth.currentUser
                    if (user != null) {
                        saveCredentials(user.email.toString(), user.displayName.toString())
<<<<<<< HEAD
                        user.email.toString()?.let {
                            val intent = Intent(this@MainActivity, CategoryActivity::class.java)
                            intent.putExtra("name", user.email.toString())
                            intent.putExtra("email", user.displayName.toString())
                            startActivity(intent)
                        }

=======
                        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + user.getIdToken(true))
                        Toast.makeText(this, " ${user.email.toString()} - ${user.displayName.toString()}", Toast.LENGTH_SHORT).show()
                        setContent {
                            Proyecto001Theme {
                                user.email.toString()?.let {
                                    val intent = Intent(this@MainActivity, CategoryActivity::class.java)
                                    intent.putExtra("name", user.email.toString())
                                    intent.putExtra("email", user.displayName.toString())
                                    startActivity(intent)

                                }
                            }
                        }
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
                    } else
                        Toast.makeText(this, " null user", Toast.LENGTH_SHORT).show()
                    //Redirect
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Google : Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    @Composable
    fun Login() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.color07)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .offset(y = (-20).dp)
                    .width(350.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 15.dp
            ) {
                Column(
                    modifier = Modifier
                        .width(350.dp)
                        .height(450.dp)
                        .clip(shape = RoundedCornerShape(25.dp))
                        .background(Color.White)
                        .padding(top = 10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Red)) {
                                append("M")
                            }
                            append("is ")

                            withStyle(style = SpanStyle(color = Color.Blue)) {
                                append("F")
                            }
                            append("inanzas ")

                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Green)) {
                                append("P")
                            }
                            append("ersonales")
                        },
                        style = MaterialTheme.typography.h1,
                        fontSize = 30.sp,
                        color = Color.Black

                    )
                    Divider(modifier = Modifier.width(280.dp),color = colorResource(id = R.color.color07), thickness = 1.dp)
                    Image(
                        painter = painterResource(id = R.drawable.finanzas_login),
                        contentDescription = "Cat Logo",
                        modifier = Modifier
                            .size(300.dp)
                    )
                    GoogleButton()
                }
            }
        }

    }

    @Composable
    fun GoogleButton(){
        Button(onClick = {
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignIngClient = GoogleSignIn.getClient(this, googleConf)
            val signInIntent = googleSignIngClient.signInIntent
            startActivityForResult(signInIntent, GOOGLE_SIGN_IN)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.color07)),
        ) {
            Image(
                modifier = Modifier.padding(1.dp),
                painter = painterResource(id = R.drawable.ic_google_foreground),
                contentDescription = "Google")
            Text(text = stringResource(id = R.string.google_button), color = Color.Black)
        }
    }
}
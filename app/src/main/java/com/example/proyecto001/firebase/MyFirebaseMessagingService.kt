package com.example.proyecto001.firebase

import android.content.Context
import android.util.Log
import com.example.proyecto001.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    companion object{
        const val TAG = "FIREBASE"
    }
    private val dbFirestore = FirebaseFirestore.getInstance()

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.from)

        // Check if message contains a data payload.
        if (remoteMessage.data.size > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.data)
            if ( /* Check if data needs to be processed by long running job */true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                //scheduleJob()
            } else {
                // Handle message within 10 seconds
                //handleNow()
            }
        }

        // Check if message contains a notification payload.
        if (remoteMessage.notification != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.notification!!
                    .body
            )
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        //val refreshedToken: String= FirebaseMessaging.getInstance().token.toString()
        //val tokenk: Task<String> = FirebaseMessaging.getInstance().token
        // Save token on SharedPreferences
        Log.d(MyFirebaseMessagingService.TAG, getString(R.string.plusline) + " tokennn " + token)
        val preferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        preferences.putString("token", ""+token)
        preferences.apply()

        val preferencesGet = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val mail: String? = preferencesGet.getString("mail", null)
        if(mail != null){
            Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " tttttttttttttttttttttttt " + token)
            dbFirestore.collection("users").document(mail).set(
                hashMapOf("token" to token)
            )
            Log.d(MyFirebaseMessagingService.TAG, getString(R.string.guionline) + " mmmmmmmmmmmmmmmmmmmmmmmm " + mail)
        }


    }
}
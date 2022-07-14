package com.example.proyecto001.database.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsManager(context: Context) {
    private val dataStore = context.dataStore

    fun userDataStore(){
        val exampleCounterFlow: Flow<Int> = dataStore.data
            .map { preferences ->
                // No type safety.
                preferences[COUNTER] ?: 0
            }
    }

    suspend fun incrementCounter() {
        dataStore.edit { settings ->
            val currentCounterValue = settings[COUNTER] ?: 0
            settings[COUNTER] = currentCounterValue + 1
        }
    }

    val counter: Flow<Int>
        get() = dataStore.data.map { preferences ->
            preferences[COUNTER] ?: 0
        }

    companion object {
        val COUNTER = intPreferencesKey("counter_key")
    }

}

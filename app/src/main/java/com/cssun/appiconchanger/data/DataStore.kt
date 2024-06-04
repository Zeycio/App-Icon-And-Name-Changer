package com.cssun.appiconchanger.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppData(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("AppData")
        val ICON_KEY = intPreferencesKey("icon_key")
        val STRING_KEY = intPreferencesKey("string_key")
    }


    val getIcon: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[ICON_KEY] ?: 0
    }
    val getName: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[STRING_KEY] ?: 0
    }

    suspend fun setIcon(icon: Int) {
        context.dataStore.edit { preferences ->
            preferences[ICON_KEY] = icon
        }
    }

    suspend fun setName(name: Int) {
        context.dataStore.edit { preferences ->
            preferences[STRING_KEY] = name
        }
    }


}

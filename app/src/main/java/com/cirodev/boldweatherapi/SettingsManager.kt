package com.cirodev.boldweatherapi

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SettingsManager.DATA_STORE)

class SettingsManager(
    private val context: Context
) {

    companion object {
        const val DATA_STORE = "settings"
        private val THEME_KEY = stringPreferencesKey("app_theme_key")
        private val LANG_KEY = stringPreferencesKey("app_lang_key")
    }

    fun getConfig(key: Preferences.Key<String>): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[key]
        }
    }

    suspend fun saveConfig(key: Preferences.Key<String>, value: String) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun deleteConfig(key: Preferences.Key<String>) {
        context.dataStore.edit { preferences ->
            preferences.remove(key)
        }
    }

}
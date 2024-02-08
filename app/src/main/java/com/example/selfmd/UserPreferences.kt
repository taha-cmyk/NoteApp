package com.example.selfmd

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject


interface UserPreference {
    fun theme(): Flow<String>
    suspend fun saveUserTheme(theme: String)

    fun font(): Flow<String>
    suspend fun saveUserFont(font: String)

    fun fontSize(): Flow<String>
    suspend fun saveFontSize(fontSize: String)


}

 class UserDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
): UserPreference {


    override fun theme(): Flow<String> {
        return dataStore.data
            .catch {
                emit(emptyPreferences())
            }
            .map { preference ->
                preference[KEYS.KEY_USER_THEME] ?: Theme.LIGHT.toString()
            }
    }


    override suspend fun saveUserTheme(theme: String) {
        dataStore.edit { preference ->
            preference[KEYS.KEY_USER_THEME] = theme
        }
    }

    override fun font(): Flow<String> {
        return dataStore.data
            .catch {
                emit(emptyPreferences())
            }
            .map { preference ->
                preference[KEYS.KEY_USER_FONT] ?: Font.DEFAULT.toString()
            }
    }


    override suspend fun saveUserFont(font: String) {
        dataStore.edit { preference ->
            preference[KEYS.KEY_USER_FONT] = font
        }
    }

    override fun fontSize(): Flow<String> {
        TODO("Not yet implemented")
    }


    override suspend fun saveFontSize(fontSize: String) {
        TODO("Not yet implemented")
    }


}

object KEYS {
    val KEY_USER_THEME = stringPreferencesKey("user_them")
    val KEY_USER_FONT= stringPreferencesKey("user_font")
    val KEY_USER_FONT_SIZE=stringPreferencesKey("user_font_size")
}
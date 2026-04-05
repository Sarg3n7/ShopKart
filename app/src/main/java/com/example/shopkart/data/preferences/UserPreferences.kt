package com.example.shopkart.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {

    companion object {
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_EMAIL = stringPreferencesKey("user_email")
        val USER_PHOTO_URL = stringPreferencesKey("user_photo_url")
        val SEARCH_RADIUS = intPreferencesKey("search_radius")
        val USE_AUTO_LOCATION = booleanPreferencesKey("use_auto_location")
        val LAST_KNOWN_LAT = floatPreferencesKey("last_known_lat")
        val LAST_KNOWN_LNG = floatPreferencesKey("last_known_lng")
    }

    // User info
    val userName: Flow<String> = context.dataStore.data.map { it[USER_NAME] ?: "" }
    val userEmail: Flow<String> = context.dataStore.data.map { it[USER_EMAIL] ?: "" }
    val userPhotoUrl: Flow<String> = context.dataStore.data.map { it[USER_PHOTO_URL] ?: "" }

    // Settings
    val searchRadius: Flow<Int> = context.dataStore.data.map { it[SEARCH_RADIUS] ?: 3000 }
    val useAutoLocation: Flow<Boolean> = context.dataStore.data.map { it[USE_AUTO_LOCATION] ?: true }

    // Last known location
    val lastKnownLat: Flow<Float> = context.dataStore.data.map { it[LAST_KNOWN_LAT] ?: 0f }
    val lastKnownLng: Flow<Float> = context.dataStore.data.map { it[LAST_KNOWN_LNG] ?: 0f }

    suspend fun saveUserInfo(name: String, email: String, photoUrl: String) {
        context.dataStore.edit { prefs ->
            prefs[USER_NAME] = name
            prefs[USER_EMAIL] = email
            prefs[USER_PHOTO_URL] = photoUrl
        }
    }

    suspend fun saveSearchRadius(radius: Int) {
        context.dataStore.edit { it[SEARCH_RADIUS] = radius }
    }

    suspend fun saveUseAutoLocation(value: Boolean) {
        context.dataStore.edit { it[USE_AUTO_LOCATION] = value }
    }

    suspend fun saveLastKnownLocation(lat: Float, lng: Float) {
        context.dataStore.edit { prefs ->
            prefs[LAST_KNOWN_LAT] = lat
            prefs[LAST_KNOWN_LNG] = lng
        }
    }

    suspend fun clearUserInfo() {
        context.dataStore.edit { prefs ->
            prefs.remove(USER_NAME)
            prefs.remove(USER_EMAIL)
            prefs.remove(USER_PHOTO_URL)
        }
    }
}
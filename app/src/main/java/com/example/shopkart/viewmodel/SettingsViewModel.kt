package com.example.shopkart.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopkart.data.preferences.UserPreferences
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val userPreferences = UserPreferences(application)
    private val remoteConfig = FirebaseRemoteConfig.getInstance()

    val searchRadius: StateFlow<Int> = userPreferences.searchRadius
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 3000)

    val useAutoLocation: StateFlow<Boolean> = userPreferences.useAutoLocation
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    val userName: StateFlow<String> = userPreferences.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "")

    val userEmail: StateFlow<String> = userPreferences.userEmail
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "")


    private val _remoteConfigValues = MutableStateFlow<Map<String, String>>(emptyMap())
    val remoteConfigValues: StateFlow<Map<String, String>> = _remoteConfigValues

    init {
        loadRemoteConfigValues()
    }

    private fun loadRemoteConfigValues() {
        _remoteConfigValues.value = mapOf(
            "banner_text" to remoteConfig.getString("banner_text"),
            "default_radius" to remoteConfig.getLong("default_radius").toString(),
            "featured_category" to remoteConfig.getString("featured_category")
        )
    }

    fun updateSearchRadius(radius: Int) {
        viewModelScope.launch {
            userPreferences.saveSearchRadius(radius)
        }
    }

    fun updateUseAutoLocation(value: Boolean) {
        viewModelScope.launch {
            userPreferences.saveUseAutoLocation(value)
        }
    }

    fun refreshRemoteConfig() {
        remoteConfig.fetchAndActivate().addOnCompleteListener {
            loadRemoteConfigValues()
        }
    }
}
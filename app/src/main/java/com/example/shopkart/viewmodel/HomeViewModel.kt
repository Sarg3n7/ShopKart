package com.example.shopkart.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopkart.data.local.AppDatabase
import com.example.shopkart.data.preferences.UserPreferences
import com.example.shopkart.data.remote.PlaceResult
import com.example.shopkart.data.repository.StoreRepository
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

// Sealed class — like a union type in TypeScript
sealed class SearchState {
    object Idle : SearchState()
    object Loading : SearchState()
    data class Success(val stores: List<PlaceResult>) : SearchState()
    data class Error(val message: String) : SearchState()
    object Empty : SearchState()
}

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val repository = StoreRepository(db)
    private val userPreferences = UserPreferences(application)
    private val remoteConfig = FirebaseRemoteConfig.getInstance()

    // Search state
    private val _searchState = MutableStateFlow<SearchState>(SearchState.Idle)
    val searchState: StateFlow<SearchState> = _searchState

    // Recent searches from Room DB
    val recentSearches = repository.getRecentSearches()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Remote config values
    private val _bannerText = MutableStateFlow("🛍️ Discover stores near you!")
    val bannerText: StateFlow<String> = _bannerText

    private val _defaultRadius = MutableStateFlow(3000)
    val defaultRadius: StateFlow<Int> = _defaultRadius

    private val _featuredCategory = MutableStateFlow("Electronics")
    val featuredCategory: StateFlow<String> = _featuredCategory

    // Current search query
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    // Current location
    private var currentLat: Double = 0.0
    private var currentLng: Double = 0.0

    init {
        setupRemoteConfig()
        loadSavedLocation()
    }

    private fun setupRemoteConfig() {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(
            mapOf(
                "banner_text" to "🛍️ Discover stores near you!",
                "default_radius" to 3000L,
                "featured_category" to "Electronics"
            )
        )
        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                _bannerText.value = remoteConfig.getString("banner_text")
                _defaultRadius.value = remoteConfig.getLong("default_radius").toInt()
                _featuredCategory.value = remoteConfig.getString("featured_category")
            }
        }
    }

    private fun loadSavedLocation() {
        viewModelScope.launch {
            val lat = userPreferences.lastKnownLat.first()
            val lng = userPreferences.lastKnownLng.first()
            if (lat != 0f && lng != 0f) {
                currentLat = lat.toDouble()
                currentLng = lng.toDouble()
            } else {
                // Default to Bangalore if no location saved yet
                currentLat = 12.9716
                currentLng = 77.5946
            }
        }
    }

    fun updateLocation(lat: Double, lng: Double) {
        currentLat = lat
        currentLng = lng
        viewModelScope.launch {
            userPreferences.saveLastKnownLocation(lat.toFloat(), lng.toFloat())
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun searchStores(apiKey: String, radiusOverride: Int? = null) {
        val query = _searchQuery.value.trim()
        if (query.isEmpty()) return
        if (currentLat == 0.0 && currentLng == 0.0){
            currentLat = 12.8441
            currentLng = 77.6794
        }

        _searchState.value = SearchState.Loading

        viewModelScope.launch {
            // Save to recent searches
            repository.saveSearch(query)

            val radius = radiusOverride ?: userPreferences.searchRadius.first()

            val result = repository.getNearbyStores(
                lat = currentLat,
                lng = currentLng,
                radius = radius,
                keyword = query,
                apiKey = apiKey
            )

            result.fold(
                onSuccess = { stores ->
                    _searchState.value = if (stores.isEmpty()) {
                        SearchState.Empty
                    } else {
                        SearchState.Success(stores)
                    }
                },
                onFailure = { error ->
                    _searchState.value = SearchState.Error(
                        error.message ?: "Something went wrong"
                    )
                }
            )
        }
    }

    fun resetSearch() {
        _searchState.value = SearchState.Idle
        _searchQuery.value = ""
    }
}
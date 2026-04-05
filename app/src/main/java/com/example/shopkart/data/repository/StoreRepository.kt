package com.example.shopkart.data.repository

import com.example.shopkart.data.local.AppDatabase
import com.example.shopkart.data.local.CachedStoreEntity
import com.example.shopkart.data.local.SearchEntity
import com.example.shopkart.data.remote.MockPlacesData
import com.example.shopkart.data.remote.OpeningHours
import com.example.shopkart.data.remote.PlaceLocation
import com.example.shopkart.data.remote.PlaceResult
import kotlinx.coroutines.flow.Flow

class StoreRepository(private val db: AppDatabase) {

    private val dao = db.searchDao()

    // Search History

    fun getRecentSearches(): Flow<List<SearchEntity>> = dao.getRecentSearches()

    suspend fun saveSearch(query: String) {
        dao.insertSearch(SearchEntity(query = query.trim()))
        dao.trimSearches()
    }



    suspend fun getNearbyStores(
        lat: Double,
        lng: Double,
        radius: Int,
        keyword: String,
        apiKey: String
    ): Result<List<PlaceResult>> {
        return try {
            // Simulate network delay for realistic feel
            kotlinx.coroutines.delay(1000)

            val results = MockPlacesData.getStoresForKeyword(keyword)

            // Cache results locally
            cacheStores(results, keyword)

            Result.success(results)
        } catch (e: Exception) {
            // Try returning cached results on failure
            val cached = getCachedStores(keyword)
            if (cached.isNotEmpty()) {
                Result.success(cached.map { it.toPlaceResult() })
            } else {
                Result.failure(e)
            }
        }
    }

    // Cache

    private suspend fun cacheStores(stores: List<PlaceResult>, query: String) {
        val entities = stores.map { place ->
            CachedStoreEntity(
                placeId = place.placeId,
                name = place.name,
                vicinity = place.vicinity,
                lat = place.location.latitude,
                lng = place.location.longitude,
                rating = place.rating,
                icon = place.icon,
                searchQuery = query
            )
        }
        dao.insertStores(entities)
        dao.deleteOldCache(System.currentTimeMillis() - 24 * 60 * 60 * 1000)
    }

    suspend fun getCachedStores(query: String): List<CachedStoreEntity> {
        return dao.getCachedStores(query)
    }

    // Helper Function

    private fun CachedStoreEntity.toPlaceResult(): PlaceResult {
        return PlaceResult(
            placeId = placeId,
            name = name,
            vicinity = vicinity,
            rating = rating,
            location = PlaceLocation(lat, lng),
            icon = icon,
            openingHours = OpeningHours(openNow = false)
        )
    }
}
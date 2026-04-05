package com.example.shopkart.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {

    // Recent searches
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearch(search: SearchEntity)

    @Query("SELECT * FROM recent_searches ORDER BY timestamp DESC LIMIT 5")
    fun getRecentSearches(): Flow<List<SearchEntity>>

    @Query("DELETE FROM recent_searches WHERE id NOT IN (SELECT id FROM recent_searches ORDER BY timestamp DESC LIMIT 5)")
    suspend fun trimSearches()

    // Cached stores
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStores(stores: List<CachedStoreEntity>)

    @Query("SELECT * FROM cached_stores WHERE searchQuery = :query")
    suspend fun getCachedStores(query: String): List<CachedStoreEntity>

    @Query("DELETE FROM cached_stores WHERE timestamp < :cutoffTime")
    suspend fun deleteOldCache(cutoffTime: Long)
}
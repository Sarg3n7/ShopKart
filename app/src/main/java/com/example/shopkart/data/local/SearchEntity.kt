package com.example.shopkart.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_searches")
data class SearchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val query: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "cached_stores")
data class CachedStoreEntity(
    @PrimaryKey val placeId: String,
    val name: String,
    val vicinity: String,
    val lat: Double,
    val lng: Double,
    val rating: Double,
    val icon: String,
    val searchQuery: String,
    val timestamp: Long = System.currentTimeMillis()
)
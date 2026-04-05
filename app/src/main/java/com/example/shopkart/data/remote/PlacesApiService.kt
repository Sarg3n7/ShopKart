package com.example.shopkart.data.remote

import com.google.gson.annotations.SerializedName


data class PlaceResult(
    val placeId: String = "",
    val name: String = "",
    val vicinity: String = "",
    val rating: Double = 0.0,
    val location: PlaceLocation = PlaceLocation(),
    val types: List<String> = emptyList(),
    val icon: String = "",
    val openingHours: OpeningHours? = null,
    val userRatingsTotal: Int = 0
)

data class PlaceLocation(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)

data class OpeningHours(
    val openNow: Boolean = false
)
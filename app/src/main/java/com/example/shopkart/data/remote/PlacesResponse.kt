package com.example.shopkart.data.remote

//import com.google.gson.annotations.SerializedName
//
//data class PlacesResponse(
//    @SerializedName("results") val results: List<PlaceResult> = emptyList(),
//    @SerializedName("status") val status: String = ""
//)
//
//data class PlaceResult(
//    @SerializedName("place_id") val placeId: String = "",
//    @SerializedName("name") val name: String = "",
//    @SerializedName("vicinity") val vicinity: String = "",
//    @SerializedName("rating") val rating: Double = 0.0,
//    @SerializedName("geometry") val geometry: Geometry = Geometry(),
//    @SerializedName("types") val types: List<String> = emptyList(),
//    @SerializedName("icon") val icon: String = "",
//    @SerializedName("opening_hours") val openingHours: OpeningHours? = null,
//    @SerializedName("user_ratings_total") val userRatingsTotal: Int = 0
//)
//
//data class Geometry(
//    @SerializedName("location") val location: Location = Location()
//)
//
//data class Location(
//    @SerializedName("lat") val lat: Double = 0.0,
//    @SerializedName("lng") val lng: Double = 0.0
//)
//
//data class OpeningHours(
//    @SerializedName("open_now") val openNow: Boolean = false
//)
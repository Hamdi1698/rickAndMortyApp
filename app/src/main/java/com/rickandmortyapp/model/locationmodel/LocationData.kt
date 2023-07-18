package com.rickandmortyapp.model.locationmodel


import com.google.gson.annotations.SerializedName


data class LocationData(
    @SerializedName("info")
    val info: İnfo,
    @SerializedName("results")
    val resultsss: List<Resultsss>
)
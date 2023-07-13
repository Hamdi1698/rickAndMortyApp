package com.rickandmortyapp.model


import com.google.gson.annotations.SerializedName

data class LocationX(
    @SerializedName("info")
    val info: İnfoX,
    @SerializedName("results")
    val results: List<ResultX>
)
package com.rickandmortyapp.model


import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("info")
    val info: İnfoXX,
    @SerializedName("results")
    val results: List<ResultXX>
)
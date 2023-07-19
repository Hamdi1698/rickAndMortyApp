package com.rickandmortyapp.model


import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Results>
)
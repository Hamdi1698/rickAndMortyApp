package com.rickandmortyapp.model


import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("info")
    val info: İnfo,
    @SerializedName("results")
    val results: List<Results>
)



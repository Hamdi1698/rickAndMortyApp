package com.rickandmortyapp.model


import com.google.gson.annotations.SerializedName

data class İnfoXX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: Any?
)
package com.rickandmortyapp.model.episodemodel


import com.google.gson.annotations.SerializedName

data class EpisodeModel(
    @SerializedName("info")
    val info: İnfo,
    @SerializedName("results")
    val results: List<Result>
)
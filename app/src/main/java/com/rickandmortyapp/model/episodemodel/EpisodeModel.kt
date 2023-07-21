package com.rickandmortyapp.model.episodemodel


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeModel(
    @SerializedName("info")
    val info: İnfo,
    @SerializedName("results")
    val results: List<Resultsssss>
):Parcelable
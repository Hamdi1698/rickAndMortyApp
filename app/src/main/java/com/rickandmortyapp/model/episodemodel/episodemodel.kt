package com.rickandmortyapp.model.episodemodel


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class episodemodel(
    @SerializedName("info")
    val info: İnfo,
    @SerializedName("results")
    val results: List<Result>
):Parcelable
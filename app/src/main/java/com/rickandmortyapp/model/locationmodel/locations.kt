package com.rickandmortyapp.model.locationmodel


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class locations(
    @SerializedName("info")
    val info: İnfoLocation,
    @SerializedName("results")
    val results: List<ResultLocation>
):Parcelable
package com.rickandmortyapp.model.locationmodel


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resultsss(
    @SerializedName("created")
    val created: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
):Parcelable
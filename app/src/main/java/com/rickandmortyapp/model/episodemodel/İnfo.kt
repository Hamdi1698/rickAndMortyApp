package com.rickandmortyapp.model.episodemodel


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.rickandmortyapp.model.locationmodel.İnfoLocation
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class İnfo(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: Any?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().orEmpty(),
        parcel.readInt(),
        parcel.readValue(Any::class.java.classLoader)
    )

    companion object CREATORR : Parceler<İnfo> {
        fun createFromParcel(parcel: Parcel): İnfoLocation {
            return İnfoLocation(parcel)
        }

        override fun İnfo.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(count)
            parcel.writeString(next)
            parcel.writeInt(pages)
            parcel.writeValue(prev)
        }

        override fun create(parcel: Parcel): İnfo = TODO()
    }

}
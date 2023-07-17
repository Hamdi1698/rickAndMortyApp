package com.rickandmortyapp.model.locationmodel


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

data class İnfoLocation(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: Any?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().orEmpty(),
        parcel.readInt(),
        parcel.readValue(Any::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(count)
        parcel.writeString(next)
        parcel.writeInt(pages)
        parcel.writeValue(prev)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<İnfoLocation> {
        override fun createFromParcel(parcel: Parcel): İnfoLocation {
            return İnfoLocation(parcel)
        }

        override fun newArray(size: Int): Array<İnfoLocation?> {
            return arrayOfNulls(size)
        }
    }
}
package com.example.smartummah.model

import android.os.Parcel
import android.os.Parcelable

data class Prayer(
    var prayerName: String,
    var prayerTime: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(prayerName)
        parcel.writeString(prayerTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Prayer> {
        override fun createFromParcel(parcel: Parcel): Prayer {
            return Prayer(parcel)
        }

        override fun newArray(size: Int): Array<Prayer?> {
            return arrayOfNulls(size)
        }
    }

}
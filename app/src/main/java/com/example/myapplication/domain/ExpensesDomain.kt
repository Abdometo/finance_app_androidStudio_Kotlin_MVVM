package com.example.myapplication.domain

import android.os.Parcel
import android.os.Parcelable

data class ExpensesDomain(
    val title: String = "",
    val price: Double = 0.0,
    val pic: String = "",
    val time: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeDouble(price)
        parcel.writeString(pic)
        parcel.writeString(time)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ExpensesDomain> {
        override fun createFromParcel(parcel: Parcel): ExpensesDomain {
            return ExpensesDomain(parcel)
        }

        override fun newArray(size: Int): Array<ExpensesDomain?> {
            return arrayOfNulls(size)
        }
    }
}

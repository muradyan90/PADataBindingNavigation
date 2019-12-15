package com.aram.padatabindingnavigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(var name: String = "", var lastName: String = ""): Parcelable

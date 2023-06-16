package com.dicoding.dfruitz.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val image: Int,
    val title: String,
    val date: String
) : Parcelable


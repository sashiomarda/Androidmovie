package com.example.androidmovie.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var id: String,
    var title: String,
    var description: String,
    var date: String,
    var imagePath: String
) : Parcelable


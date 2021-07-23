package com.example.githubuserapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (
    var username: String="",
    var name: String="",
    var image: Int=0,
    var follower: Int=0,
    var following: Int=0,
    var repository: Int = 0,
    var company: String="",
    var location: String=""
):Parcelable
package com.example.claroperro

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val id: String,
    val name: String,
    val origin: String,
    val intelligence: Int,
    val strangerFriendly: Int,
    val description: String,
    val lifeSpan: String,
    val temperament: String,
    val childFriendly: Int,
    val wiki: String,
    val countryCode: String,
    val imgId: String
) : Parcelable

data class Weight(
    val imperial: String
)

data class DogImage (
    val url: String
)
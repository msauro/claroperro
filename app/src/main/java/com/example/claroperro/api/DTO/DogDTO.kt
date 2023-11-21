package com.example.claroperro.api.DTO

import com.example.claroperro.Weight
import com.squareup.moshi.Json

class DogDTO(
    val id: String,
    val name: String,
    val origin: String,
    val intelligence: Int,
    @Json(name = "country_code") val countryCode: String,
    @Json(name = "stranger_friendly") val strangerFriendly: Int,
    val description: String,
    @Json(name="life_span") val lifeSpan: String,
    val temperament: String,
    @Json(name = "child_friendly")  val childFriendly: Int,
    val weight: Weight,
    @Json(name="wikipedia_url") val wiki: String
)
package com.jjp.petsitter.model

import com.google.gson.annotations.SerializedName

data class Animal
constructor(
        @SerializedName("id") val id: Long,
        @SerializedName("type") private val type: String,
        @SerializedName("name") private val name: String,
        @SerializedName("age") private val age: String,
        @SerializedName("gender") private val gender: String,
        @SerializedName("size") private val size: String,
        @SerializedName("description") private val description: String,
        @SerializedName("published_at") private val publishedAt: String,
        @SerializedName("distance") private val distance: Double
)

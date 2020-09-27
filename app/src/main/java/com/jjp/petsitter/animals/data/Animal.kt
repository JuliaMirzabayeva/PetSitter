package com.jjp.petsitter.animals.data

import com.google.gson.annotations.SerializedName

data class Animal(
    @SerializedName("id") val id: Long,
    @SerializedName("type") val type: String,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("breeds") val breeds: Breeds,
    @SerializedName("size") val size: String,
    @SerializedName("contact") val contact: Contact,
    @SerializedName("description") val description: String?,
    @SerializedName("published_at") val publishedAt: String,
    @SerializedName("distance") val distance: Double
)

data class Breeds(
    @SerializedName("primary") val primary: String?,
    @SerializedName("secondary") val secondary: String?,
    @SerializedName("mixed") val mixed: Boolean,
    @SerializedName("unknown") val unknown: Boolean
)

data class Contact(
    @SerializedName("email") val email: String?,
    @SerializedName("phone") val phone: String,
    @SerializedName("address") val address: Address
)

data class Address(
    @SerializedName("city") val city: String,
    @SerializedName("country") val country: String
)

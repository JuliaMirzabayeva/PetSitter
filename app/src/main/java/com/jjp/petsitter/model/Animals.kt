package com.jjp.petsitter.model

import com.google.gson.annotations.SerializedName

data class Animals
constructor(
    @SerializedName("animals") val animals: List<Animal>,
    @SerializedName("pagination") val pagination: Pagination
)

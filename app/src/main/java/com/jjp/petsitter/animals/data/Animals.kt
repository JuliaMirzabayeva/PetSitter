package com.jjp.petsitter.animals.data

import com.google.gson.annotations.SerializedName

data class Animals(
    @SerializedName("animals") val animals: List<Animal>,
    @SerializedName("pagination") val pagination: Pagination
)

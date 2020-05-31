package com.jjp.petsitter.animals.data

import com.google.gson.annotations.SerializedName

data class Token(
        @SerializedName("token_type") val tokenType: String,
        @SerializedName("expires_in") val expiresIn: Long,
        @SerializedName("access_token") val accessToken: String
)

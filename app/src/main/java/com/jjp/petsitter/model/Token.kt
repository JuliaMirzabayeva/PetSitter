package com.jjp.petsitter.model

import com.google.gson.annotations.SerializedName

data class Token
constructor(
        @SerializedName("token_type") val tokenType: String,
        @SerializedName("expires_in") val expiresIn: Long,
        @SerializedName("access_token") val accessToken: String
)

package com.jjp.petsitter.api.request

import com.google.gson.annotations.SerializedName

data class TokenRequest(
       @SerializedName("grant_type") val grantType: String,
       @SerializedName("client_id") val clientId: String,
       @SerializedName("client_secret") val clientSecret: String
)

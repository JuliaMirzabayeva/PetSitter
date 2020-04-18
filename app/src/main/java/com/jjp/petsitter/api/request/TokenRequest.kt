package com.jjp.petsitter.api.request

data class TokenRequest
constructor(
       val grant_type: String,
       val client_id: String,
       val client_secret: String
)

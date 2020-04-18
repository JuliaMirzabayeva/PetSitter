package com.jjp.petsitter.api

import com.jjp.petsitter.model.Token
import com.jjp.petsitter.api.request.TokenRequest
import com.jjp.petsitter.model.Animals
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("/v2/oauth2/token")
    fun getToken(@Body request: TokenRequest): Call<Token>

    @GET("/v2/animals")
    fun getAnimals(@Header("Authorization") token: String): Call<Animals>
}

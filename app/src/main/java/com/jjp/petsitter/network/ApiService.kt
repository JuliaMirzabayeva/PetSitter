package com.jjp.petsitter.network

import com.jjp.petsitter.animals.data.Token
import com.jjp.petsitter.animals.data.TokenRequest
import com.jjp.petsitter.animals.data.Animals
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("oauth2/token")
    fun getToken(@Body request: TokenRequest): Call<Token>

    @GET("animals")
    fun getAnimals(@Header("Authorization") token: String): Call<Animals>
}

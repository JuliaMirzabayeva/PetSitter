package com.jjp.petsitter.ui

import com.jjp.petsitter.api.RetrofitClient
import com.jjp.petsitter.api.request.TokenRequest
import com.jjp.petsitter.model.Animal
import com.jjp.petsitter.model.Token
import retrofit2.await

class AnimalsLoader {

    private val apiService = RetrofitClient.apiService

    suspend fun loadAnimals(): List<Animal> {
        try {
            val token = loadToken()
            val response = apiService
                .getAnimals(TOKEN_HEADER.format(token.tokenType, token.accessToken))
                .await()
            return response.animals
        } catch (cause: Throwable) {
            throw cause
        }
    }

    private suspend fun loadToken(): Token {
        try {
            val tokenRequest = TokenRequest(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET)
            return apiService
                .getToken(tokenRequest)
                .await()
        } catch (cause: Throwable) {
            throw cause
        }
    }

    companion object {
        private const val GRANT_TYPE = "client_credentials"
        private const val CLIENT_ID = "GM1XJB8uDCHXIhWUrQt1uwvZde1797czskejpt8KENJV7RFMXb"
        private const val CLIENT_SECRET = "GO5spEg9L0P76kdmhNb6rLagee5gcI0dqWlcqq74"

        private const val TOKEN_HEADER = "%s %s"
    }
}

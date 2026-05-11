package com.example.actividad1am.quotes

import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiInterface {

    @GET("api/random")
    suspend fun getRandomQuote(): Response<List<QuoteResponse>>
}

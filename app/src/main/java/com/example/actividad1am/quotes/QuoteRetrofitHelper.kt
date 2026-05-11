package com.example.actividad1am.quotes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuoteRetrofitHelper {

    private val URL_BASE = "https://zenquotes.io/"

    fun getRetrofitService(): QuoteApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: QuoteApiInterface = retrofit.create(QuoteApiInterface::class.java)
        return service
    }
}

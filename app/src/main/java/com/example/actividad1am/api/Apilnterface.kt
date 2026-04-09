package com.example.actividad1am.api
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("breeds/image/random")
    suspend fun imagenAleatoria(): Response<ImagenRandom>
}
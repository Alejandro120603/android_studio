package com.example.actividad1am.pokemonapi
//Paso 2: PokemonApiInterface -> paso 3:PokemonRetrofitHelper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

// Interface de Retrofit: aquí se describen las peticiones que haremos a PokéAPI.
interface PokemonApiInterface {

    // @GET indica el endpoint que se agrega después de la base URL.
    // En este caso se forma una URL como: https://pokeapi.co/api/v2/pokemon/25
    @GET("pokemon/{id}")
    suspend fun getPokemonById(
        // @Path reemplaza {id} por el número recibido.  Esto lo hace random
        @Path("id") id: Int
    ): Response<PokemonResponse>
    // Response<PokemonResponse> permite revisar si la respuesta fue exitosa
    // y también obtener el body convertido a nuestro modelo PokemonResponse.
    // suspend significa que esta función se puede pausar mientras llega internet
    // sin congelar la pantalla principal de Android.
}

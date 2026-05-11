package com.example.actividad1am.pokemonapi
//paso 3:PokemonRetrofitHelper -> paso 4: PokemonAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Helper encargado de preparar Retrofit para conectarse a PokéAPI.
object PokemonRetrofitHelper {

    // baseUrl es la parte fija de la URL de la API.
    // Retrofit necesita que termine en "/" para poder unir correctamente los endpoints.
    private const val URL_BASE = "https://pokeapi.co/api/v2/"

    fun getRetrofitService(): PokemonApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            // Gson convierte el JSON recibido de internet a objetos Kotlin.
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // retrofit.create() genera el código necesario para usar PokemonApiInterface.
        val service: PokemonApiInterface = retrofit.create(PokemonApiInterface::class.java)
        return service
    }
}

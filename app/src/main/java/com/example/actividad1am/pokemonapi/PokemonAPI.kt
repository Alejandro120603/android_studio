package com.example.actividad1am.pokemonapi
//paso 4: PokemonAPI -> paso 5: PokemonViewModel
// Esta clase es una capa intermedia entre el ViewModel y Retrofit.
// Su trabajo es llamar al servicio de internet y regresar datos simples al ViewModel.
class PokemonAPI {
    private val service = PokemonRetrofitHelper.getRetrofitService()

    suspend fun getPokemonAleatorio(): PokemonResponse? {
        // PokéAPI no tiene un endpoint pokemon/random.
        // Por eso simulamos el random con un ID aleatorio de la primera generación.
        val randomId = (1..151).random()
        val response = service.getPokemonById(randomId)

        return if (response.isSuccessful) {
            // Si la respuesta fue exitosa, regresamos el body convertido a PokemonResponse.
            response.body()
        } else {
            // Si el Pokémon no existe o hubo error HTTP, regresamos null.
            null
        }
    }
}

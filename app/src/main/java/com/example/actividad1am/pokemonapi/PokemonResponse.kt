package com.example.actividad1am.pokemonapi
//Paso 1 PokemonResponse -> Paso 2: PokemonApiInterface
// Estos data class representan la parte del JSON de PokéAPI que queremos usar.
// No es necesario copiar todo el JSON, solo los campos que la app va a mostrar.
data class PokemonResponse(
    // Nombre
    val name: String,
    // Altura
    val height: Int,
    // Peso
    val weight: Int,
    // imágenes del Pokémon.
    val sprites: PokemonSprites
)

data class PokemonSprites(
    // URL de la imagen frontal. Puede venir null si la API no tiene imagen.
    val front_default: String?
)

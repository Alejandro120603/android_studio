package com.example.actividad1am.pokemonapi
//paso 6: PokemonView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

// Pantalla simple para probar el módulo de PokéAPI.
// Lee los datos del ViewModel y los muestra con Compose.
@Composable
fun PokemonView(pokemonViewModel: PokemonViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Pokémon del día")

        Button(onClick = {
            // Al presionar el botón se consulta un Pokémon aleatorio en PokéAPI.
            pokemonViewModel.traerPokemonAleatorio()
        }) {
            Text(text = "Mostrar Pokémon aleatorio")
        }

        if (pokemonViewModel.isLoading) {
            Text(text = "Cargando...")
        }

        if (pokemonViewModel.error.isNotBlank()) {
            Text(text = pokemonViewModel.error)
        }

        if (pokemonViewModel.name.isNotBlank()) {
            // Estos textos leen el estado actualizado desde el ViewModel.
            Text(text = "Nombre: ${pokemonViewModel.name}")
            Text(text = "Altura: ${pokemonViewModel.height}")
            Text(text = "Peso: ${pokemonViewModel.weight}")
        }

        if (pokemonViewModel.imageUrl.isNotBlank()) {
            // AsyncImage es de Coil y carga la imagen desde la URL.
            AsyncImage(
                model = pokemonViewModel.imageUrl,
                contentDescription = "Imagen del Pokémon"
            )
        }
    }
}

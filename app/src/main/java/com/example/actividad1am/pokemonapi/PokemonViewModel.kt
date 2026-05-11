package com.example.actividad1am.pokemonapi
//paso 5: PokemonViewModel paso 6: PokemonView
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// ViewModel de la pantalla Pokémon.
// Guarda el estado que Compose va a leer para dibujar la pantalla.
class PokemonViewModel : ViewModel() {

    var name by mutableStateOf("")
        private set

    var height by mutableStateOf("")
        private set

    var weight by mutableStateOf("")
        private set

    var imageUrl by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    fun traerPokemonAleatorio() {
        val api = PokemonAPI()

        // Limpiamos errores anteriores y activamos el estado de carga.
        error = ""
        isLoading = true

        viewModelScope.launch {
            try {
                // La llamada a internet se hace en Dispatchers.IO para no bloquear la interfaz.
                val pokemon = withContext(Dispatchers.IO) {
                    api.getPokemonAleatorio()
                }

                if (pokemon != null) {
                    // Si la API respondió bien, llenamos los estados que muestra la pantalla.
                    name = pokemon.name
                    height = pokemon.height.toString()
                    weight = pokemon.weight.toString()
                    imageUrl = pokemon.sprites.front_default ?: ""
                } else {
                    // Si no hubo body, normalmente es porque el Pokémon no existe.
                    name = ""
                    height = ""
                    weight = ""
                    imageUrl = ""
                    error = "No se encontró ese Pokémon."
                }
            } catch (exception: Exception) {
                // El try/catch evita que la app se cierre si falla internet o la API.
                name = ""
                height = ""
                weight = ""
                imageUrl = ""
                error = "No se pudo consultar PokéAPI."
            } finally {
                // finally se ejecuta al terminar, haya éxito o error.
                isLoading = false
            }
        }
    }
}

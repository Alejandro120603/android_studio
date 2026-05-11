package com.example.actividad1am.quotes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuoteViewModel : ViewModel() {

    var frase by mutableStateOf(QuoteRepository.FALLBACK_QUOTE)
        private set

    var cargando by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    fun traerFraseMotivacional() {
        val repository = QuoteRepository()

        viewModelScope.launch {
            cargando = true
            error = ""

            val resultado = withContext(Dispatchers.IO) {
                repository.getRandomQuote()
            }

            frase = resultado
            cargando = false

            if (resultado == QuoteRepository.FALLBACK_QUOTE) {
                error = "No se pudo cargar una frase nueva."
            }
        }
    }
}

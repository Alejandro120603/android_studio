package com.example.actividad1am.api

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DogViewModel: ViewModel() {

    var url by mutableStateOf(value = "")
        private set

    fun traerUrlImagen() {
        val api = API()

        viewModelScope.launch {
            withContext(context = Dispatchers.IO) {
                url = api.getImagenAleatoria()
            }
        }
    }
}
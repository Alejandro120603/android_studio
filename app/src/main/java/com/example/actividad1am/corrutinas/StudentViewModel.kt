package com.example.actividad1am.corrutinas

import android.util.Log
import android.util.Log.e
import java.lang.Thread.sleep
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentsViewModel: ViewModel() {
    var isLoading by mutableStateOf(false)
    var lista = mutableListOf<String>()
        private set
    var winner by mutableStateOf("")
        private set
    fun getWinner() {
        isLoading = true

        try {
            viewModelScope.launch {
                winner = ""
                changePerson()
                isLoading = false
            }
        } catch (e: Exception){
            Log.e("ERROR_BACKGROUND", "Error en modulo studentsViewModel $e")
        }finally {
            isLoading = false
        }


    }
    suspend fun changePerson(){
        withContext(Dispatchers.IO){
            isLoading = true
            delay(5000)
            winner = "Juan Perez Perez"
            isLoading = false
        }

    }

}
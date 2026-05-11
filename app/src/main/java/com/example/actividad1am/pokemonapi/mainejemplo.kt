package com.example.actividad1am.pokemonapi

/*import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.examenordinario_23414.ordinario.RickAndMortyView
import com.example.examenordinario_23414.ordinario.RickAndMortyViewModel
import com.example.examenordinario_23414.ui.theme.Examenordinario_23414Theme
import android.annotation.SuppressLint
import com.example.examenordinario_23414.ui.theme.Examenordinario_23414Theme

/*
class MainActivity : ComponentActivity() {

    // Paso 1: Crear el ViewModel fuera del Composable.
    private val viewModel = RickAndMortyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Examenordinario_23414Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    // Paso 2: Pasar el ViewModel a la pantalla.
                    RickAndMortyView(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
} */

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Examenordinario_23414Theme {
                RickAndMortyView(RickAndMortyViewModel())
            }
        }
    }
} */
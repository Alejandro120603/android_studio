package com.example.actividad1am.ActNavegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ActForm(navController: NavHostController) {

    // guarda lo que escribe el usuario
    var anioNacimiento by remember { mutableStateOf("") }

    // muestra error si el dato no es válido
    var mensajeError by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // convierte el texto a número
                    val anio = anioNacimiento.toIntOrNull()

                    when {
                        anio == null -> {
                            mensajeError = "Ingresa un año válido"
                        }

                        else -> {
                            val edad = 2026 - anio

                            mensajeError = ""
                            navController.navigate(Resultado(edad))
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Continuar"
                )
            }
        }
    ) { paddingInterno ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Actividad - Navegación",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(
                        text = "Ingresa tu año de nacimiento"
                    )
                    //cuadro donde el usuario escribe texto
                    OutlinedTextField(
                        value = anioNacimiento,
                        onValueChange = {
                            anioNacimiento = it
                        },
                        label = {
                            Text("Año de nacimiento")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    if (mensajeError.isNotEmpty()) {
                        Text(
                            text = mensajeError,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}
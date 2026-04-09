package com.example.actividad1am.persistencia

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun ProfileView(){
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf(0) }
    var haspet by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val preferences = Preferencias(context)
    val corrutina = rememberCoroutineScope()

    var nombreGuardado = preferences.name.collectAsState(initial = "")
    var edadGuardada = preferences.age.collectAsState(initial = 0)
    var mascotaGuardada = preferences.hasPet.collectAsState(initial = false)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mi perfil")

        Text(
            text = "Datos guardados hasta ahora son: ${edadGuardada.value} -- " +
                    "${nombreGuardado.value} y ${mascotaGuardada.value}"
        )

        TextField(
            value = nombre,
            onValueChange = {
                nombre = it
            }
        )

        Switch(haspet, onCheckedChange = {
            haspet = it
        })

        val coroutineScope = rememberCoroutineScope()

        Button(onClick = {
            corrutina.launch {
                preferences.GuardarDatosPersonales(
                    edad,
                    nombre,
                    haspet
                )
            }
        }) {
            Text(text = "Guardar")
        }
    }
}
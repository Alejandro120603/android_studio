package com.example.actividad1am.componentes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividad1am.R



// FUNCIÓN QUE DIBUJA LA CANCHA DE TENIS

@Composable
fun CanchaTenisUI(
    modifier: Modifier = Modifier
) {
    // Box = contenedor que permite superponer elementos
    Box(
        modifier = modifier
            .background(Color(0xFF1E8E3E)) // Color verde cancha
            .padding(16.dp)               // Espacio interno
    ) {

        // BORDES EXTERNOS
        // Línea izquierda
        Box(
            Modifier
                .fillMaxHeight()   // Ocupa toda la altura
                .width(4.dp)       // Grosor línea
                .background(Color.White)
                .align(Alignment.CenterStart)
        )

        // Línea derecha
        Box(
            Modifier
                .fillMaxHeight()
                .width(4.dp)
                .background(Color.White)
                .align(Alignment.CenterEnd)
        )

        // Línea superior
        Box(
            Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.White)
                .align(Alignment.TopCenter)
        )

        // Línea inferior
        Box(
            Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.White)
                .align(Alignment.BottomCenter)
        )

        // LÍNEA CENTRAL VERTICAL
        Box(
            Modifier
                .fillMaxHeight()
                .width(4.dp)
                .background(Color.White)
                .align(Alignment.Center)
        )
        // LÍNEA CENTRAL HORIZONTAL (red)
        Box(
            Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.White)
                .align(Alignment.Center)
        )
    }
}


// FUNCIÓN MARCADOR DE JUGADORES
@Composable
fun MarcadorJugadoresUI(
    nombre1: String,
    nombre2: String
) {

    // Estado de puntos
    var puntos1 by remember { mutableStateOf(0) }
    var puntos2 by remember { mutableStateOf(0) }

    // Row = organiza horizontalmente
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .background(Color(0xFFEDEDED)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // JUGADOR 1
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.amir),
                contentDescription = "Jugador 1",
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = nombre1, fontSize = 18.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                // Botón Restar
                IconButton(onClick = {
                    if (puntos1 > 0) puntos1--
                }) {
                    Icon(Icons.Default.Remove, contentDescription = "Restar")
                }

                Text(text = puntos1.toString(), fontSize = 20.sp)

                // Botón Sumar
                IconButton(onClick = {
                    puntos1++
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Sumar")
                }
            }
        }

        Text(text = "VS", fontSize = 20.sp)
        // JUGADOR 2
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.gustambo),
                contentDescription = "Jugador 2",
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = nombre2, fontSize = 18.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                IconButton(onClick = {
                    if (puntos2 > 0) puntos2--
                }) {
                    Icon(Icons.Default.Remove, contentDescription = "Restar")
                }

                Text(text = puntos2.toString(), fontSize = 20.sp)

                IconButton(onClick = {
                    puntos2++
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Sumar")
                }
            }
        }
    }
}

// 🖥 FUNCIÓN PRINCIPAL (PANTALLA COMPLETA)
@Preview(showBackground = true)
@Composable
fun PantallaCompleta() {

    // Estados de los nombres
    var nombre1 by remember { mutableStateOf("Amir") }
    var nombre2 by remember { mutableStateOf("Gustambo") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Cancha ocupa el espacio principal
        CanchaTenisUI(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        // Campos para cambiar nombres
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            TextField(
                value = nombre1,
                onValueChange = { nombre1 = it },
                label = { Text("Jugador 1") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = nombre2,
                onValueChange = { nombre2 = it },
                label = { Text("Jugador 2") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Marcador
        MarcadorJugadoresUI(
            nombre1 = nombre1,
            nombre2 = nombre2
        )
    }
}
package com.example.actividad1am.componentes

import androidx.compose.foundation.Image
//import androidx.compose.foundation.R ESTE IMPORT ES MALO
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.actividad1am.R

/*
@Preview(showBackground = true)
@Composable
fun MiBoton() {

    // Variable de estado que guarda el mensaje actual
    // remember → mantiene el valor aunque la UI se redibuje
    // mutableStateOf → hace que Compose escuche cambios y actualice la pantalla
    var mimensaje by remember {
        mutableStateOf("Adiós")
    }

    Column( // Organiza los elementos en vertical
        modifier = Modifier.fillMaxSize(), // Ocupatodo el tamaño de la pantalla
        horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente
        verticalArrangement = Arrangement.Center // Centra verticalmente
    ) {

        Text(text = mimensaje)

        Button(// Crea un botón

            onClick = { // Se ejecuta cuando se presiona el botón
                if (mimensaje == "Adiós") { // Muestra el valor actual del mensaje
                    mimensaje = "Hola"  // Si el mensaje actual es "Adiós"
                } else {                    // Cambia a Hola
                    mimensaje = "Adiós"    // Si no, cambia a Adiós
                }
            },

            modifier = Modifier.fillMaxWidth(), // Hace que el botón ocupe todo el ancho

            colors = ButtonDefaults.buttonColors( // Personaliza los colores del botón
                contentColor = Color.White, // Color del texto del botón
                containerColor = Color(0xFFFF9800)
            )

        ) {
            Text(text = "Aceptar") // Texto que aparece dentro del botón
        }
    }

}*/

@Preview(showBackground = true)
@Composable
fun CambioImagen() {

    var imagenActual by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(
                id = when (imagenActual) {
                    0 -> R.drawable.amir
                    1 -> R.drawable.gustambo
                    else -> R.drawable.bronto
                }
            ),
            contentDescription = "Imagen dinámica",
            modifier = Modifier.size(200.dp)
            .clickable {   //  AQUÍ está el click en la imagen
                imagenActual = (imagenActual + 1) % 3
            }
        )

        Button(
            onClick = {
                imagenActual = (imagenActual + 1) % 3
            }
        ) {
            Text("Cambiar imagen") //
        }
    }
}
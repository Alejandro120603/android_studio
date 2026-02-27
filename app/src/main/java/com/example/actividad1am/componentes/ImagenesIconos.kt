package com.example.actividad1am.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.actividad1am.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp


/* @Preview (showBackground = true)
@Composable
fun ImagenView() {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.amir),
                contentDescription = "Imagen de portada",
                contentScale = ContentScale.FillBounds
            )

            Text(
                modifier = Modifier
                    .alpha(alpha = 0.7f)
                    .background(Color.Black)
                    .align(Alignment.Center),
                text = "Un gato",
                color = Color.Yellow,
                fontSize = 65.sp
            )
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun IconView() {

    Column() { // Organiza los elementos en vertical


        Icon( // Muestra un ícono en pantalla
            painter = painterResource(R.drawable.amir),  // Carga una imagen desde drawable
            contentDescription = "Icono de gato", // Descripción para accesibilidad
            tint = Color.Unspecified // No aplica color, usa los colores originales
        )

//iconos https://fonts.google.com/icons
        Icon(
            imageVector = Icons.Default.Android, // Ícono de Material Icons (vectorial)
            contentDescription = "Icono de cierre", // Texto descriptivo para accesibilidad
            tint = Color.Red
        )
        Icon(
            imageVector = Icons.Default.AddCircle, // Ícono de Material Icons (vectorial)
            contentDescription = "Icono de cierre", // Texto descriptivo para accesibilidad
            tint = Color.Red,
            modifier = Modifier.size(80.dp) // Cambia el tamaño

        )
    }
}
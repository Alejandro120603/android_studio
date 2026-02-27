package com.example.actividad1am.componentes

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TextoDecoradoView (){
    Text(text = "hola",
        color = Color.Red,
        modifier = Modifier.
        padding(8.dp).
        background(Color.Blue).
        padding(8.dp).
        background(Color.Yellow).
        padding(start = 5.dp).
        background(Color.Black).
        padding(end = 5.dp, top = 4.dp).
        background(Color.DarkGray).
        padding(horizontal = 4.dp).
        background(Color.Magenta)
    )
}

@Preview(showBackground = true)
@Composable
fun TextoCompletoView (){
    Text(text = "Saludo amigoooooooooooooooo",

        modifier = Modifier.background(Color.Yellow).
        //size(24.dp). // Define alto y ancho iguales (cuadrado)
        //height(24.dp). // Define solo la altura
        width(85.dp). // Define solo el ancho
        //fillMaxSize(). // Ocupatodo el alto y ancho disponible
        //fillMaxHeight() // Ocupatodo el alto disponible
        //fillMaxWidth() // Ocupatodo el ancho disponible
        padding(8.dp). // Agrega espacio interno alrededor del contenido
        alpha(0.5f). // Hace el componente semi-transparente (50%)
        blur(2.dp).// Aplica efecto de desenfoque
        border(width = 2.dp, color = Color.Green).// Agrega un borde verde de 2dp
        //padding(8.dp)
        padding(top = 16.dp, start = 8.dp).// Agrega espacio extra arriba y a la izquierda
        horizontalScroll(rememberScrollState()) // Permite desplazamiento horizontal
    // si el contenido es más grande

        )
}
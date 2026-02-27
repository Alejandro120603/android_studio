package com.example.actividad1am.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants

@Preview (showBackground = true)
@Composable
fun ColumnaRepaso(){
    Column(modifier = Modifier.fillMaxSize().// Ocupa todo el espacio disponible de la pantalla
    background(Color(color = 0xFF751313)),// Fondo color vino personalizado
        //verticalArrangement = Arrangement.Top, // center medio bold abajo top arriba
        horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos horizontalmente
        verticalArrangement = Arrangement.SpaceBetween // Distribuye el espacio entre los elementos verticalmente

        )
    {
        Text(text = "Hola", fontSize = 80.sp) // Tamaño grande del texto
        Spacer( modifier = Modifier.height(50.dp).// Alto del espacio vacío
        fillMaxWidth().// Ocupatodo el ancho
        background(Color.Yellow).// Fondo amarillo
        background(Color.Blue)) // Este sobreescribe el amarillo (solo se verá azul)
        Text(text = "Adios", fontSize = 80.sp, modifier = Modifier.background(Color.Yellow))
        Spacer( modifier = Modifier.height(50.dp).// Alto del espacio
            width(140.dp). // Ancho específico
        padding(8.dp).// Espacio interno
        background(Color.Blue))// Espacio interno
        Text(text = "No se", fontSize = 80.sp, modifier = Modifier.background(Color.Yellow))
    }
}


@Preview(showBackground = true) // Muestra vista previa con fondo en Android Studio
@Composable // Indica que es una función de interfaz en Compose
fun ColumnaFinal() {

    Column(
        modifier = Modifier.fillMaxSize() // La columna ocupa toda la pantalla
    ) {

        Text(
            text = "1", // Texto que se muestra
            fontSize = 80.sp, // Tamaño grande del texto
            modifier = Modifier
                .fillMaxHeight() // Intenta ocupartodo el alto disponible
                .weight(0.25f) // Ocupa 0.25 partes del espacio total disponible
                .background(Color.Blue) // Fondo azul
        )

        Text(
            text = "2",
            fontSize = 80.sp,
            modifier = Modifier
                .fillMaxHeight() // Intenta ocupartodo el alto disponible
                .weight(1f) // Ocupa 1 parte del espacio
                .background(Color.Red) // Fondo rojo
        )

        Text(
            text = "3",
            fontSize = 80.sp,
            modifier = Modifier
                .fillMaxHeight() // Intenta ocupartodo el alto disponible
                .weight(1f) // Ocupa 1 parte del espacio
        )

        /*
        Peso total = 0.25 + 1 + 1 = 2.25
        Cada elemento ocupa:
        0.25 / 2.25  ≈ 11%
        1 / 2.25     ≈ 44%
        1 / 2.25     ≈ 44%
        */
    }
}
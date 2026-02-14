package com.example.actividad1am.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun Botones() {

    var texto by remember { mutableStateOf("lol") }
    var activo by remember { mutableStateOf(false) }

    fun cambiartexto() {
        activo = !activo
        texto = if (activo) "no" else "si"
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(text = texto)

        Button(
            onClick = { cambiartexto() },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFFEC0F0F),
                containerColor = Color(0xFFCC6E6E)
            )
        ) {
            Text(text = "Click me")
        }
    }
}

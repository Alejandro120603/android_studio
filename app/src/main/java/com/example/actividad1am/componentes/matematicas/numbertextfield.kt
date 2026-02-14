package com.example.actividad1am.componentes.matematicas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun numbertextfill ( modificador: Modifier, fill:(String)-> Unit){

    var number by remember { mutableStateOf(value = "") }
            Column(modifier = modificador.background(Color.Blue)) {
                Text("Ingresa un numero")
                TextField(value = number, onValueChange = { textoEscrito ->
                    //val uper = textoEscrito.uppercase()
                    if (textoEscrito.toIntOrNull() !=null){
                        number = textoEscrito.toInt().toString()
                        fill(number)
                    }
                })
            }
}

@Preview
@Composable
fun numbertextfillpreview(){
    var texto by remember { mutableStateOf(value = "") }
    Column() {
        Text(texto)

    numbertextfill(modificador = Modifier.fillMaxWidth()){
        texto=it
    }
    }
}
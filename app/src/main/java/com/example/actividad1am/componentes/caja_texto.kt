package com.example.texto

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.actividad1am.componentes.matematicas.numbertextfill

@Preview(showBackground = true)
@Composable

fun cajasTexto(){
    var number by remember {
        mutableStateOf("")
    }

    var number2 by remember{
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.fillMaxWidth()) {
            numbertextfill(modificador = Modifier.fillMaxWidth().weight(weight = 2f)){number = it}
            Spacer(modifier = Modifier.fillMaxWidth().weight(weight = 1f))
            numbertextfill(modificador = Modifier.fillMaxWidth().weight(weight = 2f)){number = it}

        }///

        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment =  Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(onClick = {}) {
                Text("Restart")
            }

            Spacer(modifier = Modifier.width(width = 8.dp))
            Text(text = "borrar todo", modifier = Modifier.clickable(
                onClick = {
                    result = ""
                    number = ""
                    number2 = ""
                }

            ))
            Spacer(modifier = Modifier.width(width = 8.dp))
            IconButton({
                if (number.toIntOrNull() !=null && number2.toShortOrNull() !=null){
                    result = (number.toInt()+number2.toInt()).toString()
                }
                else{
                    result = "Favor ingresa solo numeros loser"
                }
            }) {
                Icon(imageVector = Icons.Default.Add, "sumar")
            }
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {

            }) {
                Text(text = "Multiplicar")
            }
            TextButton(onClick = {}) {
                Text(text = "Dividir")
            }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(result)
    }
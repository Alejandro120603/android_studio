package com.example.actividad1am.componentes

import androidx.compose.foundation.background      // fondo de pantalla
import androidx.compose.foundation.layout.*       // Column, Row, Box, Spacer
import androidx.compose.material3.*               // Button y Text
import androidx.compose.runtime.*                 // estados (remember)
import androidx.compose.ui.Alignment              // alineación
import androidx.compose.ui.Modifier               // modificar tamaño, color
import androidx.compose.ui.graphics.Color         // colores
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp                // tamaños en dp
import androidx.compose.ui.unit.sp                // tamaño texto


@Composable
fun CalculadoraBasica() {

    var numeroActual by remember { mutableStateOf("") }   // guarda número que se escribe
    var numeroAnterior by remember { mutableStateOf("") } // guarda número previo
    var operador by remember { mutableStateOf("") }       // guarda operador + o -

    Column(
        modifier = Modifier
            .fillMaxSize()                // ocupa toda la pantalla
            .background(Color.Black)      // fondo negro
            .padding(16.dp)               // espacio interno
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()           // ocupa todo el ancho
                .height(120.dp),          // altura de pantalla resultado
            contentAlignment = Alignment.BottomEnd // texto abajo derecha
        ) {
            Text(
                text = numeroActual,      // muestra número actual
                color = Color.White,      // texto blanco
                fontSize = 40.sp          // texto grande
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // espacio vertical

        @Composable
        fun BotonCalculadora(
            texto: String,               // texto del botón
            onClick: () -> Unit,         // acción del botón
            color: Color = Color.DarkGray // color por defecto
        ) {
            Button(
                onClick = onClick,        // ejecuta acción al presionar
                modifier = Modifier
                    .size(80.dp)          // tamaño botón
                    .padding(4.dp),       // espacio entre botones
                colors = ButtonDefaults.buttonColors(containerColor = color) // color botón
            ) {
                Text(text = texto, fontSize = 20.sp) // texto del botón
            }
        }

        Row {
            BotonCalculadora(texto = "7", onClick = { numeroActual += "7" }) // agrega 7
            BotonCalculadora(texto = "8", onClick = { numeroActual += "8" }) // agrega 8
            BotonCalculadora(texto = "9", onClick = { numeroActual += "9" }) // agrega 9
            BotonCalculadora(
                texto = "+",
                onClick = {
                    numeroAnterior = numeroActual   // guarda número actual
                    numeroActual = ""               // limpia pantalla
                    operador = "+"                  // guarda operador suma
                },
                color = Color(0xFFFF9800)           // botón naranja
            )
        }

        Row {
            BotonCalculadora(texto = "4", onClick = { numeroActual += "4" }) // agrega 4
            BotonCalculadora(texto = "5", onClick = { numeroActual += "5" }) // agrega 5
            BotonCalculadora(texto = "6", onClick = { numeroActual += "6" }) // agrega 6
            BotonCalculadora(
                texto = "-",
                onClick = {
                    numeroAnterior = numeroActual   // guarda número actual
                    numeroActual = ""               // limpia pantalla
                    operador = "-"                  // guarda operador resta
                },
                color = Color(0xFFFF9800)           // botón naranja
            )
        }

        Row {
            BotonCalculadora(texto = "1", onClick = { numeroActual += "1" }) // agrega 1
            BotonCalculadora(texto = "2", onClick = { numeroActual += "2" }) // agrega 2
            BotonCalculadora(texto = "3", onClick = { numeroActual += "3" }) // agrega 3
            BotonCalculadora(
                texto = "=",
                onClick = {
                    if (numeroAnterior.isNotEmpty() && numeroActual.isNotEmpty()) {
                        val resultado = when (operador) { // decide operación
                            "+" -> numeroAnterior.toInt() + numeroActual.toInt() // suma
                            "-" -> numeroAnterior.toInt() - numeroActual.toInt() // resta
                            else -> 0
                        }
                        numeroActual = resultado.toString() // muestra resultado
                        numeroAnterior = ""                 // limpia anterior
                        operador = ""                       // limpia operador
                    }
                },
                color = Color(0xFF4CAF50) // botón verde igual
            )
        }

        Row {
            BotonCalculadora(texto = "0", onClick = { numeroActual += "0" }) // agrega 0
            BotonCalculadora(
                texto = "C",
                onClick = {
                    numeroActual = ""     // limpia número actual
                    numeroAnterior = ""   // limpia número anterior
                    operador = ""         // limpia operador
                },
                color = Color.Red         // botón rojo limpiar
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCalculadora() {
    CalculadoraBasica() // muestra calculadora en preview
}
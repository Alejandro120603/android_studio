package com.example.actividad1am.navegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController


@Composable
fun ReportView(navegante: NavHostController) {
    var nombreSeccion by remember { mutableStateOf(value = "") }
    var numSeccion by remember { mutableStateOf(value = "") }
    var nombreEncargado by remember { mutableStateOf(value = "") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Reporte de ventas")
        Button(onClick = {
            navegante.popBackStack()
        }) {
            Text("Regresar")
        }
        TextField(
            value = nombreSeccion,
            onValueChange = { nombreSeccion = it },
            label = { Text(text = "Nombre de la sección") }
        )

        TextField(
            value = numSeccion,
            onValueChange =  { numSeccion = it },
            label = { Text(text = "Numero de la sección") }
        )

        TextField(
            value = nombreEncargado,
            onValueChange =  { nombreEncargado = it },
            label = { Text(text = "Nombre del encargado") }
        )
        Button(onClick = {
            navegante.navigate(
                route = ReportModel(
                    numeroSeccion = numSeccion.toInt(),
                    nombreEncargado = nombreSeccion,
                    nombreSeccion = nombreEncargado
                )
            )
        }) {
            Text(text = "Enviar datos")
        }
    }
}
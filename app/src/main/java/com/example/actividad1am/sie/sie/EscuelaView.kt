package com.example.moviles.sie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun EscuelaView(navegante: NavHostController) {
    var userName by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("SIE IEST v.1.22474487139…",
            modifier = Modifier.padding(9.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        TextField(value = userName, onValueChange = {userName = it}, label = {Text(text = "Nombre del usuario")})
        TextField(value = userId, onValueChange = {userId = it}, label = {Text(text = "Numero de ID")})
        Button(onClick = {
            if (userId.toInt() >= 1 && userId.toInt() <= 10) {
                navegante.navigate(
                    CoordEscuela( userId = userId.trim().toInt(),
                        userName = userName))
            } else if (userId.toInt() >= 20050 && userId.toInt() <= 20200){
                navegante.navigate(EstudianteEscuela( userId = userId.trim().toInt(),
                    userName = userName))
            } else {
                navegante.navigate(Error)

            }

        }) {
            Text(text = "Enviar Datos")
        }


    }
}
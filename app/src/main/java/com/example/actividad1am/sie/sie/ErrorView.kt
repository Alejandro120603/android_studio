package com.example.moviles.sie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable

fun ErrorView(navegante: NavHostController){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "ERROR 404: \nID NO ENCONTRADO",
            color = Color.Red,
            fontSize = 40.sp
        )

        Button(onClick = {
            navegante.navigate(
                Home2)
        }) {
            Text(text = "Regresar")
        }
    }
}


package com.example.moviles.sie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

val orange = Color(0xFFFF9800)

@Composable
fun MateriaInfo(califParam: Materias, navegante: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "IEST ANAHUAC",
            color = orange,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Calificacion",
                fontSize = 20.sp,
                color = Color.Black
            )

            Text(
                text = califParam.calif.toString(),
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Faltas",
                fontSize = 20.sp,
                color = Color.Black
            )

            Text(
                text = "1/10.5",
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Button(
            onClick = {
                navegante.popBackStack()
            }
        ) {
            Text(text = "Regresar")
        }
    }
}
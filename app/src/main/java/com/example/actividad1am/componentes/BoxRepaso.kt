package com.example.actividad1am.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun CajaView() {

    Box(
        modifier = Modifier.size(209.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(text = "Primero")

        Text(
            text = "Segundo",
            modifier = Modifier.align(Alignment.BottomEnd)
        )

        Text(
            text = "3",
            modifier = Modifier.align(Alignment.TopStart)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MiVista() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(all = 8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "<--", fontSize = 24.sp)
            Text(text = "-->", fontSize = 24.sp)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
        ) {
            // Título arriba (por defecto TopStart)
            Text(
                text = "Titulo",
                fontSize = 24.sp,
                modifier =
                    Modifier.align(Alignment.Center)
            )
            // Pie de página abajo centrado
            Text(
                text = "Pie de pagina",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
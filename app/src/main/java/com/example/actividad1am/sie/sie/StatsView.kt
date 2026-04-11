package com.example.moviles.sie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun StatsView(
    generarReporte2: CoordEscuela = CoordEscuela(1, "juan")
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Nombre del Coordinador: ${generarReporte2.userName}",
            fontSize = 20.sp
        )

        Text(
            text = "Numero de ID: ${generarReporte2.userId}",
            fontSize = 20.sp
        )

        ListView2(1)
    }
}

@Composable
fun PDFPreview() {
    val reporte2 = CoordEscuela(1, "juan")
    StatsView(reporte2)
}
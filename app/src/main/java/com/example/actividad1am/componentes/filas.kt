package com.example.actividad1am.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun Filas() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // ===== COLUMNA 1 (igual, no se toca) =====
        Column {
            Text(text = "uno")
            Text(text = "4")
            Text(text = "5")
            Text(text = "6")
        }

        // ===== COLUMNA 2 (igual, no se toca) =====
        Column(Modifier.width(100.dp)) {
            Text(text = "dos")
        }

        // ===== COLUMNA 3 (NUEVA, ESTA ES LA QUE PIDES) =====
        Column(Modifier.width(100.dp)) {
            Text(text = "tres")

            // fila superior
            Row {
                Box(
                    Modifier
                        .background(Color.Red)
                        .width(20.dp)
                        .height(20.dp)
                ) {}

                Box(
                    Modifier
                        .background(Color.Blue)
                        .width(50.dp)
                        .height(20.dp)
                ) {}
            }

            // fila inferior
            Row {
                Box(
                    Modifier
                        .background(Color.Black)
                        .width(50.dp)
                        .height(20.dp)
                ) {}

                Box(
                    Modifier
                        .background(Color.Red)
                        .width(20.dp)
                        .height(20.dp)
                ) {}
            }
        }
    }
}


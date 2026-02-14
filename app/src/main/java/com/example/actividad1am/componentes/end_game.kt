package com.example.actividad1am.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Undo
import androidx.compose.material.icons.filled.Sync

@Preview(showBackground = true)
@Composable
fun GameOver2048() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Título principal
        Text(
            text = "Game Over",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF776E65)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Texto secundario
        Text(
            text = "7000 points scored in 476 moves. 2 powerups used:",
            fontSize = 13.sp,
            color = Color(0xFF8F877E)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Iconos usados
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Default.Undo,
                    contentDescription = "Undo",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(10.dp))
                        .padding(8.dp)
                )
                Text(text = "3", fontSize = 12.sp, color = Color(0xFF776E65))
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Default.Sync,
                    contentDescription = "Shuffle",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(10.dp))
                        .padding(8.dp)
                )
                Text(text = "2", fontSize = 12.sp, color = Color(0xFF776E65))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Tablero congelado
        Column(
            modifier = Modifier
                .size(220.dp)
                .background(tablero, RoundedCornerShape(14.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda("2", beige)
                Celda("32", rojo)
                Celda("2", beige)
                Celda("4", beige)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda("4", beige)
                Celda("64", rojo)
                Celda("4", beige)
                Celda("128", amarillo)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda("8", naranja)
                Celda("256", amarillo)
                Celda("512", amarillo)
                Celda("8", naranja)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda("4", beige)
                Celda("8", naranja)
                Celda("2", beige)
                Celda("4", beige)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botones inferiores
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // Play Again
            Box(
                modifier = Modifier
                    .background(Color(0xFFB8A99A), RoundedCornerShape(14.dp))
                    .padding(horizontal = 40.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Play Again",
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }

            // Undo
            Box(
                modifier = Modifier
                    .background(Color(0xFFEDE5D8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 40.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Undo",
                    color = Color(0xFFB8A99A),
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Texto pequeño final
        Text(
            text = "You're out of undos!",
            fontSize = 12.sp,
            color = Color(0xFFB8A99A)
        )
    }
}
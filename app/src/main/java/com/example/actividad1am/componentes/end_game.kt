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


// ============================
// COLORES RENOMBRADOS (g3)
// ============================

val fondo_g3 = Color(0xFFE1DBD5)
val tablero_g3 = Color(0xFFB8A99A)
val beige_g3 = Color(0xFFEDE0C8)
val naranja_g3 = Color(0xFFF2B179)
val rojo_g3 = Color(0xFFF67C5F)
val amarillo_g3 = Color(0xFFF9D65C)

@Preview(showBackground = true)
@Composable
fun GameOver2048_g3() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo_g3)
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Game Over",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF776E65)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "7000 points scored in 476 moves. 2 powerups used:",
            fontSize = 13.sp,
            color = Color(0xFF8F877E)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {

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
                Text("3", fontSize = 12.sp, color = Color(0xFF776E65))
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
                Text("2", fontSize = 12.sp, color = Color(0xFF776E65))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .size(220.dp)
                .background(tablero_g3, RoundedCornerShape(14.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda_g2("2", beige_g3)
                Celda_g2("32", rojo_g3)
                Celda_g2("2", beige_g3)
                Celda_g2("4", beige_g3)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda_g2("4", beige_g3)
                Celda_g2("64", rojo_g3)
                Celda_g2("4", beige_g3)
                Celda_g2("128", amarillo_g3)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda_g2("8", naranja_g3)
                Celda_g2("256", amarillo_g3)
                Celda_g2("512", amarillo_g3)
                Celda_g2("8", naranja_g3)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda_g2("4", beige_g3)
                Celda_g2("8", naranja_g3)
                Celda_g2("2", beige_g3)
                Celda_g2("4", beige_g3)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

            Box(
                modifier = Modifier
                    .background(Color(0xFFB8A99A), RoundedCornerShape(14.dp))
                    .padding(horizontal = 40.dp, vertical = 12.dp)
            ) {
                Text("Play Again", color = Color.White, fontWeight = FontWeight.Medium)
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFEDE5D8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 40.dp, vertical = 12.dp)
            ) {
                Text("Undo", color = Color(0xFFB8A99A), fontWeight = FontWeight.Medium)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "You're out of undos!",
            fontSize = 12.sp,
            color = Color(0xFFB8A99A)
        )
    }
}

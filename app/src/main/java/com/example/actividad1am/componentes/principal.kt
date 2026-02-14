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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Undo
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.GridView

val fondo_g2 = Color(0xFFE1DBD5)
val tablero_g2 = Color(0xFFB8A99A)
val vacia_g2 = Color(0xFFCDC1B4)
val beige_g2 = Color(0xFFEDE0C8)
val naranja_g2 = Color(0xFFF2B179)
val rojo_g2 = Color(0xFFF67C5F)
val amarillo_g2 = Color(0xFFF9D65C)

@Composable
fun Header2048_g2() {

    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(Icons.Default.Menu, "Menu", tint = Color(0xFF776E65))
            Icon(Icons.Default.Refresh, "Reset", tint = Color(0xFF776E65))
        }

        Text("2048", fontSize = 36.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {

            Box(
                Modifier.background(Color(0xFFEDE5D8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 50.dp, vertical = 10.dp)
            ) {
                Text("SCORE  1692")
            }

            Box(
                Modifier.background(Color(0xFFF5F1E8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 50.dp, vertical = 10.dp)
            ) {
                Text("BEST  7000")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Fondo_g2() {

    Column(
        modifier = Modifier.fillMaxSize().background(fondo_g2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Header2048_g2()

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier.size(220.dp)
                .background(tablero_g2, RoundedCornerShape(14.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda_g2("4", beige_g2)
                Celda_g2("32", rojo_g2)
                Celda_g2("8", naranja_g2)
                Celda_g2("32", rojo_g2)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda_g2("", vacia_g2)
                Celda_g2("16", naranja_g2)
                Celda_g2("64", rojo_g2)
                Celda_g2("4", beige_g2)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda_g2("", vacia_g2)
                Celda_g2("2", beige_g2)
                Celda_g2("128", amarillo_g2)
                Celda_g2("64", rojo_g2)
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda_g2("", vacia_g2)
                Celda_g2("", vacia_g2)
                Celda_g2("8", naranja_g2)
                Celda_g2("", vacia_g2)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .background(Color(0xFFE6DED4), RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier.size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Undo, "Undo", tint = Color.White)
                }

                Box(
                    modifier = Modifier.size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Sync, "Shuffle", tint = Color.White)
                }

                Box(
                    modifier = Modifier.size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.GridView, "Grid", tint = Color.White)
                }
            }
        }
    }
}


@Composable
fun Celda_g2(texto: String, color: Color) {

    Box(
        modifier = Modifier.size(45.dp)
            .background(color, RoundedCornerShape(6.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            fontWeight = FontWeight.Bold,
            color = if (color == beige_g2) Color.Black else Color.White
        )
    }
}

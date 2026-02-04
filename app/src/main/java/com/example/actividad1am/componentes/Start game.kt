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



// Colores principales
val fondo = Color(0xFFE1DBD5)
val tablero = Color(0xFFB8A99A)
val vacia = Color(0xFFCDC1B4)
val beige = Color(0xFFEDE0C8)
val naranja = Color(0xFFF2B179)
val rojo = Color(0xFFF67C5F)
val amarillo = Color(0xFFF9D65C)

@Composable
fun Header2048() {

    // Parte de arriba (título y puntajes)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Fila de iconos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Icono de menú
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color(0xFF776E65)
            )

            // Icono de reiniciar
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset",
                tint = Color(0xFF776E65)
            )
        }

        // Texto del título
        Text(
            text = "2048",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF776E65)
        )

        // Espacio pequeño
        Spacer(modifier = Modifier.height(12.dp))

        // Cuadros de SCORE y BEST
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // Cuadro de SCORE
            Box(
                modifier = Modifier
                    .background(Color(0xFFEDE5D8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 50.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "SCORE  1692",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF776E65)
                )
            }

            // Cuadro de BEST
            Box(
                modifier = Modifier
                    .background(Color(0xFFF5F1E8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 50.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "BEST  7000",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF776E65)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Fondo() {

    // Contenedor general
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Parte de arriba
        Header2048()

        // Espacio entre header y tablero
        Spacer(modifier = Modifier.height(8.dp))


        // Tablero del juego
        Column(
            modifier = Modifier
                .size(220.dp)
                .background(tablero, RoundedCornerShape(14.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // Fila 1
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda("4", beige)
                Celda("32", rojo)
                Celda("8", naranja)
                Celda("32", rojo)
            }

            // Fila 2
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda("", vacia)
                Celda("16", naranja)
                Celda("64", rojo)
                Celda("4", beige)
            }

            // Fila 3
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda("", vacia)
                Celda("2", beige)
                Celda("128", amarillo)
                Celda("64", rojo)
            }

            // Fila 4
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda("", vacia)
                Celda("", vacia)
                Celda("8", naranja)
                Celda("", vacia)
            }

        }
        // Espacio debajo del tablero
        Spacer(modifier = Modifier.height(20.dp))

// Barra de botones de abajo
        Box(
            modifier = Modifier
                .background(Color(0xFFE6DED4), RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Botón deshacer
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Undo,
                        contentDescription = "Undo",
                        tint = Color.White
                    )
                }

                // Botón mezclar
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Sync,
                        contentDescription = "Shuffle",
                        tint = Color.White
                    )
                }

                // Botón cuadritos
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.GridView,
                        contentDescription = "Grid",
                        tint = Color.White
                    )
                }
            }
        }

    }


}

@Composable
fun Celda(texto: String, color: Color) {



    // Cuadro individual del tablero
    Box(
        modifier = Modifier
            .size(45.dp)
            .background(color, RoundedCornerShape(6.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = if (color == beige) Color.Black else Color.White
        )
    }


}

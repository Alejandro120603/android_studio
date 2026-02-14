package com.example.actividad1am.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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

// SCORE GLOBAL
var scoreGlobal by mutableStateOf(0)
var bestGlobal by mutableStateOf(0)

// -------- FUNCIONES --------

fun siguienteValor(valor: Int): Int {
    return when {
        valor <= 0 -> 2
        valor >= 2048 -> 2048
        else -> valor * 2
    }
}

fun actualizarScore(valores: List<Int>) {
    scoreGlobal = valores.sum()
    if (scoreGlobal > bestGlobal) {
        bestGlobal = scoreGlobal
    }
}

@Composable
fun Header2048() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color(0xFF776E65)
            )

            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset",
                tint = Color(0xFF776E65)
            )
        }

        Text(
            text = "2048",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF776E65)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {

            Box(
                modifier = Modifier
                    .background(Color(0xFFEDE5D8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 50.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "SCORE  $scoreGlobal",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF776E65)
                )
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFF5F1E8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 50.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "BEST  $bestGlobal",
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

    val valores = remember {
        mutableStateListOf(
            4, 32, 8, 32,
            0, 16, 64, 4,
            0, 2, 128, 64,
            0, 0, 8, 0
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Header2048()
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .size(220.dp)
                .background(tablero, RoundedCornerShape(14.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda(valores[0]) { valores[0] = it; actualizarScore(valores) }
                Celda(valores[1]) { valores[1] = it; actualizarScore(valores) }
                Celda(valores[2]) { valores[2] = it; actualizarScore(valores) }
                Celda(valores[3]) { valores[3] = it; actualizarScore(valores) }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda(valores[4]) { valores[4] = it; actualizarScore(valores) }
                Celda(valores[5]) { valores[5] = it; actualizarScore(valores) }
                Celda(valores[6]) { valores[6] = it; actualizarScore(valores) }
                Celda(valores[7]) { valores[7] = it; actualizarScore(valores) }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda(valores[8]) { valores[8] = it; actualizarScore(valores) }
                Celda(valores[9]) { valores[9] = it; actualizarScore(valores) }
                Celda(valores[10]) { valores[10] = it; actualizarScore(valores) }
                Celda(valores[11]) { valores[11] = it; actualizarScore(valores) }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Celda(valores[12]) { valores[12] = it; actualizarScore(valores) }
                Celda(valores[13]) { valores[13] = it; actualizarScore(valores) }
                Celda(valores[14]) { valores[14] = it; actualizarScore(valores) }
                Celda(valores[15]) { valores[15] = it; actualizarScore(valores) }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // -------- ICONOS RESTAURADOS --------
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
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Undo, contentDescription = "Undo", tint = Color.White)
                }

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Sync, contentDescription = "Sync", tint = Color.White)
                }

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.GridView, contentDescription = "Grid", tint = Color.White)
                }
            }
        }
    }
}

@Composable
fun Celda(valorInicial: Int, onCambio: (Int) -> Unit) {

    var valor by remember { mutableStateOf(valorInicial) }

    val color = when (valor) {
        0 -> vacia
        2, 4 -> beige
        8, 16 -> naranja
        32, 64 -> rojo
        else -> amarillo
    }

    Box(
        modifier = Modifier
            .size(45.dp)
            .background(color, RoundedCornerShape(6.dp))
            .clickable {
                valor = siguienteValor(valor)
                onCambio(valor)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (valor == 0) "" else valor.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = if (valor <= 4) Color.Black else Color.White
        )
    }
}

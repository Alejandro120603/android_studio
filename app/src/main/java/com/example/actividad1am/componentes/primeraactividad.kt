package com.example.actividad1am.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.actividad1am.componentes.GameOver2048_g3
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.filled.Undo
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.GridView
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


var pantallaActual_g1 by mutableStateOf("juego")

val fondo_g1 = Color(0xFFE1DBD5)
val tablero_g1 = Color(0xFFB8A99A)
val vacia_g1 = Color(0xFFCDC1B4)

val c2_g1 = Color(0xFFEDE0C8)
val c4_g1 = Color(0xFFE9D5B7)
val c8_g1 = Color(0xFFF2B179)
val c16_g1 = Color(0xFFF59563)
val c32_g1 = Color(0xFFF67C5F)
val c64_g1 = Color(0xFFF65E3B)
val c128_g1 = Color(0xFFEDCF72)
val c256_g1 = Color(0xFFEDCC61)
val c512_g1 = Color(0xFFEDC850)
val c1024_g1 = Color(0xFFEDC53F)
val c2048_g1 = Color(0xFFEDC22E)
var scoreGlobal_g1 by mutableStateOf(0)
var bestGlobal_g1 by mutableStateOf(0)


fun siguienteValor_g1(valor: Int): Int {
    return when {
        valor <= 0 -> 2
        valor >= 2048 -> 2048
        else -> valor * 2
    }
}

fun actualizarScore_g1(valores: List<Int>) {
    scoreGlobal_g1 = valores.sum()

    val maxValor = valores.maxOrNull() ?: 0
    if (maxValor > bestGlobal_g1) {
        bestGlobal_g1 = maxValor
    }

    if (bestGlobal_g1 >= 2048) {
        pantallaActual_g1 = "end"
    }
}


@Composable
fun Header2048_g1() {

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
                Text("SCORE  $scoreGlobal_g1")
            }

            Box(
                Modifier.background(Color(0xFFF5F1E8), RoundedCornerShape(14.dp))
                    .padding(horizontal = 50.dp, vertical = 10.dp)
            ) {
                Text("BEST  $bestGlobal_g1")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Fondo_g1() {

    val valores = remember {
        mutableStateListOf(
            4, 32, 8, 32,
            0, 16, 64, 4,
            0, 2, 128, 64,
            0, 0, 8, 0
        )
    }

    Column(
        modifier = Modifier.fillMaxSize().background(fondo_g1),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Header2048_g1()
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier.size(220.dp)
                .background(tablero_g1, RoundedCornerShape(14.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            for (fila in 0 until 4) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    for (col in 0 until 4) {
                        val index = fila * 4 + col
                        Celda_g1(valores[index]) {
                            valores[index] = it
                            actualizarScore_g1(valores)
                        }
                    }
                }
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
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp))
                        .clickable {
                            pantallaActual_g1 = "principal"
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Undo,
                        contentDescription = "Undo",
                        tint = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp))
                        .clickable {
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Sync,
                        contentDescription = "Shuffle",
                        tint = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB8A99A), RoundedCornerShape(12.dp))
                        .clickable {
                            // Aquí luego pondremos navegación
                        },
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
fun Celda_g1(valorInicial: Int, onCambio: (Int) -> Unit) {

    var valor by remember { mutableStateOf(valorInicial) }

    val color = when (valor) {
        0 -> vacia_g1
        2 -> c2_g1
        4 -> c4_g1
        8 -> c8_g1
        16 -> c16_g1
        32 -> c32_g1
        64 -> c64_g1
        128 -> c128_g1
        256 -> c256_g1
        512 -> c512_g1
        1024 -> c1024_g1
        2048 -> c2048_g1
        else -> c2048_g1
    }

    Box(
        modifier = Modifier.size(45.dp)
            .background(color, RoundedCornerShape(6.dp))
            .clickable {
                valor = siguienteValor_g1(valor)
                onCambio(valor)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (valor == 0) "" else valor.toString(),
            fontWeight = FontWeight.Bold,
            color = if (valor <= 4) Color.Black else Color.White
        )
    }
}

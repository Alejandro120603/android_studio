package com.example.moviles.sie

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

val brown = Color(0xFF6D4C41)

@Composable
fun StatsStudentView(
    generarReporte3: EstudianteEscuela = EstudianteEscuela(20050, "juan"),
    navegante: NavHostController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .height(200.dp)
        ) {
            when (generarReporte3.userId) {
                20050 -> ListView2(2)
                20051 -> ListView2(3)
                20052 -> ListView2(4)
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .height(400.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brown)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Boleta",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable {
                            navegante.navigate(Materias(10f))
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Aprendizaje Maquina", fontSize = 20.sp, color = Color.LightGray)
                    Text("10", fontSize = 20.sp, color = Color.LightGray)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable {
                            navegante.navigate(Materias(10f))
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Inteligencia Artificial", fontSize = 20.sp, color = Color.LightGray)
                    Text("10", fontSize = 20.sp, color = Color.LightGray)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable {
                            navegante.navigate(Materias(7.5f))
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Desarrollo Movil", fontSize = 20.sp, color = Color.LightGray)
                    Text("7.5", fontSize = 20.sp, color = Color.LightGray)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable {
                            navegante.navigate(Materias(9.8f))
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Geografia", fontSize = 20.sp, color = Color.LightGray)
                    Text("9.8", fontSize = 20.sp, color = Color.LightGray)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable {
                            navegante.navigate(Materias(9.5f))
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Infraestructura y Computo", fontSize = 20.sp, color = Color.LightGray)
                    Text("9.5", fontSize = 20.sp, color = Color.LightGray)
                }
            }
        }
    }
}
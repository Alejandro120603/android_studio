package com.example.actividad1am.examenparcial2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InformacionDragonView(
    select: Int,
    regresar: () -> Unit
) {
    val dragon = DragonInformacionClass().getDragonPorSelect(select)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        OutlinedButton(
            onClick = regresar,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black
            )
        ) {
            Text("Regresar")
        }

        if (dragon != null) {
            Image(
                painter = painterResource(id = dragon.imagenDetalle),
                contentDescription = dragon.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(top = 12.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Información del dragón",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            //Aquí mostramos nombre e imagen del dragón en la misma fila
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Nombre: ${dragon.nombre}")
                    Text("Apodo: ${dragon.apodo.ifEmpty { "Sin apodo" }}")
                    Text(
                        text = "Clase: ${dragon.clase}",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Image(
                    painter = painterResource(id = dragon.imagenPrincipal),
                    contentDescription = dragon.nombre,
                    modifier = Modifier.size(110.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = "Descripción: ${dragon.descripcion}",
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "Recomendación: ${dragon.recomendacion}",
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = "Nivel de peligro: ${dragon.nivelPeligro}",
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = if (dragon.entrenable) {
                    "Se puede entrenar: Sí"
                } else {
                    "Se puede entrenar: No"
                },
                modifier = Modifier.padding(top = 12.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Imagen de clase",
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(id = dragon.imagenClase),
                    contentDescription = dragon.clase,
                    modifier = Modifier.size(72.dp),
                    contentScale = ContentScale.Fit
                )
            }
        } else {
            //Aquí validamos el select por si llega un dragón inválido
            Text(
                text = "No se encontró la información del dragón",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


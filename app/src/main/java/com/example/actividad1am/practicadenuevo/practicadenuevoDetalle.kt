package com.example.actividad1am.practicadenuevo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun practicadenuevoDetalle(select: Int, regresar: () -> Unit) {

    val cuentasView = practicadenuevoProvider()
    val perfil = cuentasView.getPerfil(select)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = regresar
        ) {
            Text("Regresar")
        }

        if (perfil != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = perfil.imagen),
                        contentDescription = perfil.nombre,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "Mi perfil",
                        modifier = Modifier.padding(top = 12.dp)
                    )

                    Text(
                        text = "Nombre: ${perfil.nombre}",
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Text(
                        text = "Edad: ${perfil.edad}",
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(
                        text = "Usuario: ${perfil.usuario}",
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        } else {
            //Si algo sale raro aquí muestra que no encontró el perfil
            Text(
                text = "No se encontro el perfil",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun practicadenuevoDetallePreview() {
    MaterialTheme {
        practicadenuevoDetalle(1) {
        }
    }
}

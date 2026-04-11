package com.example.actividad1am.ActNavegacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ResultadoView(select: Int, navController: NavHostController) {

    // obtiene los datos según el select recibido
    val datos = ActDatosView().getPersona(select)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // imagen del resultado
                Image(
                    painter = painterResource(id = datos.imagen),
                    contentDescription = datos.etapa,
                    modifier = Modifier.size(180.dp)
                )

                // título
                Text(
                    text = datos.etapa,
                    style = MaterialTheme.typography.headlineSmall,
                    color = datos.color
                )

                // mensaje
                Text(
                    text = datos.mensaje,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                // botón para regresar
                Button(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text("Regresar")
                }
            }
        }
    }
}
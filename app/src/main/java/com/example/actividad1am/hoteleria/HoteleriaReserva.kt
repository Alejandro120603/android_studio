package com.example.actividad1am.hoteleria

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HoteleriaReserva(
    hotel: HoteleriaDatos?,
    reserva: HoteleriaReservaDatos,
    onNombreChange: (String) -> Unit,
    onTelefonoChange: (String) -> Unit,
    enviar: () -> Unit,
    regresarLogin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Formulario de reserva")

                if (hotel != null) {
                    Text(
                        text = "Hotel: ${hotel.nombre}",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                //Aquí el usuario pone su nombre
                OutlinedTextField(
                    value = reserva.nombre,
                    onValueChange = onNombreChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    label = {
                        Text("Nombre")
                    }
                )

                //Este campo es para el telefono
                OutlinedTextField(
                    value = reserva.telefono,
                    onValueChange = onTelefonoChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    label = {
                        Text("Telefono")
                    }
                )

                Button(
                    onClick = enviar,
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text("Enviar")
                }

                Button(
                    onClick = regresarLogin,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Regresar login")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HoteleriaReservaPreview() {
    MaterialTheme {
        HoteleriaReserva(
            hotel = HoteleriaProvider().getHotel(1),
            reserva = HoteleriaReservaProvider().getReservaVacia(),
            onNombreChange = {},
            onTelefonoChange = {},
            enviar = {},
            regresarLogin = {}
        )
    }
}

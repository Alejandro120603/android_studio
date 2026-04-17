package com.example.actividad1am.hoteleria

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
fun HoteleriaDetalle(
    hotel: HoteleriaDatos?,
    regresarLista: () -> Unit,
    reservar: () -> Unit,
    regresarLogin: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        item {
            Button(
                onClick = regresarLista
            ) {
                Text("Volver hoteles")
            }
        }

        item {
            Button(
                onClick = regresarLogin,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Regresar login")
            }
        }

        if (hotel != null) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = hotel.imagen),
                            contentDescription = hotel.nombre,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = hotel.nombre,
                            modifier = Modifier.padding(top = 12.dp)
                        )

                        Text(
                            text = "Puntuacion: ${hotel.puntuacion}",
                            modifier = Modifier.padding(top = 6.dp)
                        )

                        Text(
                            text = "Precio: ${hotel.precio}",
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        Text(
                            text = "Ubicacion: ${hotel.ubicacion}",
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        Button(
                            onClick = reservar,
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            Text("Reservar")
                        }
                    }
                }
            }
        } else {
            item {
                //Si no encuentra el hotel se muestra este texto
                Text(
                    text = "No se encontro el hotel",
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HoteleriaDetallePreview() {
    MaterialTheme {
        HoteleriaDetalle(
            hotel = HoteleriaProvider().getHotel(1),
            regresarLista = {},
            reservar = {},
            regresarLogin = {}
        )
    }
}

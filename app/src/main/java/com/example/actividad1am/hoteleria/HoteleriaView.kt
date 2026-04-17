package com.example.actividad1am.hoteleria

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HoteleriaView() {

    val hotelesView = HoteleriaProvider()
    val hoteles = hotelesView.getHoteles()
    val reservaView = HoteleriaReservaProvider()

    var usuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var nombreReserva by remember { mutableStateOf(reservaView.getReservaVacia().nombre) }
    var telefonoReserva by remember { mutableStateOf(reservaView.getReservaVacia().telefono) }
    var hotelSelect by remember { mutableIntStateOf(1) }
    //select controla qué se muestra en pantalla
    var select by remember { mutableIntStateOf(0) }
    var mensaje by remember { mutableStateOf("") }

    val hotel = hotelesView.getHotel(hotelSelect)

    if (select == 0) {
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
                    Text(text = "airbnb fake")

                    Text(
                        text = "Ingresa con el usuario de prueba",
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    OutlinedTextField(
                        value = usuario,
                        onValueChange = {
                            usuario = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        label = {
                            Text("Usuario")
                        }
                    )

                    OutlinedTextField(
                        value = contrasena,
                        onValueChange = {
                            contrasena = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        label = {
                            Text("Contraseña")
                        },
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Button(
                        onClick = {
                            //Si coincide pasa a la lista de hoteles
                            if (usuario == "alex" && contrasena == "111") {
                                mensaje = ""
                                select = 1
                            } else {
                                mensaje = "Datos incorrectos"
                            }
                        },
                        modifier = Modifier.padding(top = 12.dp)
                    ) {
                        Text("Entrar")
                    }

                    Text(
                        text = "alex / 111",
                        modifier = Modifier.padding(top = 12.dp)
                    )

                    if (mensaje.isNotEmpty()) {
                        Text(
                            text = mensaje,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    } else if (select == 1) {
        //Aquí se muestra la lista de hoteles
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    usuario = ""
                    contrasena = ""
                    mensaje = ""
                    select = 0
                }
            ) {
                Text("Regresar login")
            }

            Text(
                text = "Hoteles disponibles",
                modifier = Modifier.padding(top = 12.dp)
            )

            LazyColumn(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                items(hoteles) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                            .clickable {
                                //Si selecciona uno cambia la vista
                                hotelSelect = item.select
                                select = 2
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Image(
                                painter = painterResource(id = item.imagen),
                                contentDescription = item.nombre,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = item.nombre,
                                modifier = Modifier.padding(top = 12.dp)
                            )

                            Text(
                                text = "Puntuacion: ${item.puntuacion}",
                                modifier = Modifier.padding(top = 6.dp)
                            )

                            Text(
                                text = "Precio: ${item.precio}",
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    } else if (select == 2) {
        //Este if cambia a la pantalla del hotel solo
        HoteleriaDetalle(
            hotel = hotel,
            regresarLista = {
                select = 1
            },
            reservar = {
                select = 3
            },
            regresarLogin = {
                usuario = ""
                contrasena = ""
                nombreReserva = ""
                telefonoReserva = ""
                mensaje = ""
                select = 0
            }
        )
    } else {
        //Aquí va el form y al enviar vuelve al inicio
        HoteleriaReserva(
            hotel = hotel,
            reserva = HoteleriaReservaDatos(
                nombre = nombreReserva,
                telefono = telefonoReserva
            ),
            onNombreChange = {
                nombreReserva = it
            },
            onTelefonoChange = {
                telefonoReserva = it
            },
            enviar = {
                usuario = ""
                contrasena = ""
                nombreReserva = ""
                telefonoReserva = ""
                mensaje = "Reserva enviada"
                select = 0
            },
            regresarLogin = {
                usuario = ""
                contrasena = ""
                nombreReserva = ""
                telefonoReserva = ""
                mensaje = ""
                select = 0
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HoteleriaViewPreview() {
    MaterialTheme {
        HoteleriaView()
    }
}

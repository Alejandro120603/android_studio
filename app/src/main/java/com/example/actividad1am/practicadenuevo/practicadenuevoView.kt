package com.example.actividad1am.practicadenuevo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad1am.quotes.QuoteViewModel

@Composable
fun practicadenuevoView() {

    var usuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    val quoteViewModel = remember { QuoteViewModel() }
    //select controla que pantalla se ve
    var select by remember { mutableIntStateOf(0) }

    val cuentasView = practicadenuevoProvider()
    //Aquí traemos las cuentas que se pueden usar
    val cuentas = cuentasView.getCuentas()

    LaunchedEffect(Unit) {
        quoteViewModel.traerFraseMotivacional()
    }

    if (select == 0) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
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
                    Text(text = "Facebook falso")

                    Text(
                        text = "Inicia sesion con una cuenta de prueba",
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                    ) {
                        Text(text = "Frase motivacional")

                        Text(
                            text = if (quoteViewModel.cargando) {
                                "Cargando frase..."
                            } else {
                                quoteViewModel.frase
                            },
                            modifier = Modifier.padding(top = 6.dp)
                        )

                        if (quoteViewModel.error.isNotEmpty()) {
                            Text(
                                text = quoteViewModel.error,
                                modifier = Modifier.padding(top = 6.dp)
                            )
                        }

                        Button(
                            onClick = {
                                quoteViewModel.traerFraseMotivacional()
                            },
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Text("Otra frase")
                        }
                    }

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
                            //Si coincide entra a su perfil
                            val cuenta = cuentas.find { item ->
                                item.usuario == usuario && item.contrasena == contrasena
                            }

                            if (cuenta != null) {
                                select = cuenta.select
                            } else {
                                //Si no coincide manda a otra pantalla
                                select = 3
                            }
                        },
                        modifier = Modifier.padding(top = 12.dp)
                    ) {
                        Text("Entrar")
                    }

                    Text(
                        text = "cuenta1 / 1111",
                        modifier = Modifier.padding(top = 12.dp)
                    )

                    Text(
                        text = "cuenta2 / 2222",
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    } else if (select == 3) {
        //Este if es solo para cuando los datos no son correctos
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
                    Text(text = "Datos invalidos")

                    Text(
                        text = "La contraseña o el usuario no coinciden",
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Button(
                        onClick = {
                            usuario = ""
                            contrasena = ""
                            select = 0
                        },
                        modifier = Modifier.padding(top = 12.dp)
                    ) {
                        Text("Regresar")
                    }
                }
            }
        }
    } else {
        //Si selecciona una cuenta cambia a la vista del perfil
        practicadenuevoDetalle(select) {
            usuario = ""
            contrasena = ""
            select = 0
        }
    }
}

@Preview(showBackground = true)
@Composable
fun practicadenuevoViewPreview() {
    MaterialTheme {
        practicadenuevoView()
    }
}

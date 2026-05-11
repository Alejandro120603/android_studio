package com.example.actividad1am.examenparcial2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListadoDeDragones(
    cerrarLibro: () -> Unit,
    abrirInformacion: (Int) -> Unit
) {
    val dragonesView = Categoriasclass()
    //Aquí sacamos la lista completa
    val dragones = dragonesView.getDragones()

    //select guarda el dragon que se toca
    var select by remember { mutableIntStateOf(0) }
    var mensaje by remember { mutableStateOf("Selecciona un dragon") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //Esto queda arriba para que siga visible
        Text(
            text = mensaje,
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedButton(
            onClick = cerrarLibro,
            modifier = Modifier.padding(top = 12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black
            )
        ) {
            Text("Cerrar libro")
        }


        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(dragones) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            //Se corrige el click para que además abra la pantalla informativa
                            select = item.select
                            mensaje = "Seleccionaste: ${item.nombre}"
                            abrirInformacion(item.select)
                        }
                ) {
                    Column {
                        Box {
                            Image(
                                painter = painterResource(id = item.imagen),
                                contentDescription = item.nombre,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(220.dp),
                                contentScale = ContentScale.Crop
                            )

                            //Aquí dejamos la franja inferior negra con texto blanco centrado
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .fillMaxWidth()
                                    .background(Color.Black)
                                    .padding(vertical = 10.dp, horizontal = 12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = item.nombre,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = item.clase,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }

                        if (select == item.select) {
                            //Este if solo marca cual se tocó antes de entrar al detalle
                            Text(
                                text = "Dragon elegido",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListadoDeDragonesPreview() {
    MaterialTheme {
        ListadoDeDragones(
            cerrarLibro = {},
            abrirInformacion = {}
        )
    }
}

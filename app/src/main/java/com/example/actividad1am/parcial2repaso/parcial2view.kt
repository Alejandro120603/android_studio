package com.example.actividad1am.parcial2repaso

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad1am.ActList.ActListCategorias
import com.example.actividad1am.ActList.ActListView
import com.example.actividad1am.ActList.ProductosView

@Composable
fun parcial2view() {
    //select controla qué se muestra en pantalla empieza en 0
    var select by remember { mutableIntStateOf(0) }
    //si la variable vale 0 muestra este bloque
    if (select == 0) {
        //Voy a usar la clase ActListCategorias aqui nos traemos toda la funcion de la class
        val categoriasView = parcial2hermanos()
        //Aquí llamas la función getCategorias(). aqui nos traemos el get
        val categorias = categoriasView.getHermanos()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Hermanos")

            LazyRow(
                contentPadding = PaddingValues(top = 16.dp)
            ) {
                items(categorias) { categoria ->
                    Card(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .width(180.dp)
                            .clickable {
                                select = categoria.select
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Image(
                                painter = painterResource(id = categoria.imagen),
                                contentDescription = categoria.nombre,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = categoria.nombre,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
        //Cuando haces click en una card, cambias el valor de select.
    } else {
        //Crea una columna, es decir, pone los elementos uno debajo del otro.
        Column(
            modifier = Modifier
                //Hace que ocupe toda la pantalla.
                .fillMaxSize()
                //Le pone espacio alrededor.
                .padding(16.dp)
        ) {
            Button(
                //Cuando lo tocas, vuelve a poner select en 0.
                onClick = { select = 0 }
            ) {
                //Es el texto que aparece dentro del botón.
                Text("Regresar")
            }
            //Aquí llamas otra función composable y le mandas el valor actual de select.
            ProductosView(select)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActListViewPreview() {
    MaterialTheme {
        parcial2view()
    }
}
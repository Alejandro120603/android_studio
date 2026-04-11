package com.example.actividad1am.ActList

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

@Composable
fun ActListView() {

    var select by remember { mutableIntStateOf(0) }

    if (select == 0) {
        val categoriasView = ActListCategorias()
        val categorias = categoriasView.getCategorias()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Categorías")

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
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Button(
                onClick = { select = 0 }
            ) {
                Text("Regresar")
            }

            ProductosView(select)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActListViewPreview() {
    MaterialTheme {
        ActListView()
    }
}
package com.example.actividad1am.ActList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun ProductosView(select: Int) {

    val productosView = ActProductosCategorias()
    val productos = productosView.getProductos(select)
    val titulo = productosView.getTitulo(select)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = titulo)

        LazyColumn(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            items(productos) { producto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = producto.imagen),
                            contentDescription = producto.nombre,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = producto.nombre,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        Text(
                            text = "Precio: ${producto.precio}",
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        if (producto.envioGratis) {
                            Text(
                                text = "Envío gratis",
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        } else {
                            Text(
                                text = "Sin envío gratis",
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        if (producto.promocion.isNotEmpty()) {
                            Text(
                                text = producto.promocion,
                                modifier = Modifier.padding(top = 4.dp)
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
fun ProductosViewPreview() {
    MaterialTheme {
        ProductosView(1)
    }
}
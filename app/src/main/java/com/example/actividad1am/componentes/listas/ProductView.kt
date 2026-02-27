package com.example.actividad1am.componentes.listas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividad1am.R
import com.example.moviles.ui.theme.ProductModel
import java.nio.file.WatchEvent

@Preview(showBackground = true)
@Composable
fun ProductpreView(){
    //ProductView(image   n = R.drawable.amir, nombre = "Amir", clasificacion = 4.9f, precio = 1200, entrega = "sabado")
    //ProductView(imagen = R.drawable.amir, nombre = "Amir", clasificacion = "MUY GUAPO", precio = "INFIEL", entrega = "MAMADO")
}
@Composable
fun ProductView(producto: ProductModel){
    Card(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Column(modifier = Modifier.fillMaxWidth())  {
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = producto.imagen),
                    contentDescription = "imagen",
                    modifier = Modifier.size(150.dp)
                )

                Column(modifier = Modifier.padding(4.dp)) {
                    Text(text = producto.nombre, fontSize = 30.sp)
                    Text(text = "⭐ ${producto.calificacion}", fontSize = 17.sp)
                    Text(text = "$${producto.precio}", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Llega el ${producto.diaDeLlegada}", fontSize = 15.sp)

                    Spacer(modifier = Modifier.size(10.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.Yellow, contentColor = Color.Black)
                    ) {
                        Text(text = "Agregar")
                    }
                }
            }
        }
    }
}
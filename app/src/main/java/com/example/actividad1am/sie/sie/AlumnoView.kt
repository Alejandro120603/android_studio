package com.example.moviles.sie

import com.example.moviles.ui.theme.ProductModel
import android.widget.AdapterView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividad1am.R

import java.nio.file.WatchEvent

@Preview(showBackground = true)
@Composable
fun AlumnoPreview() {
    val computadora = AlumnoModel(
        imagen = R.drawable.amir,
        nombre = "Jesus Adrian Perez Ramos",
        calificacion = 4.8f,
        color = Color.LightGray,
        count = 6,
        id = 21364,
        carrera = "ISND",
        correo = "jesus.perez03@iest.edu.mx")
    AlumnoView(
        computadora
    ) {

    }
}
@Composable
fun AlumnoView(alumno: AlumnoModel, selected: () -> Unit) {
    var word by remember {
        mutableStateOf("Agregar al carrito")
    }

    var activo by remember {
        mutableStateOf(true)
    }

    fun cambiarTexto() {
        if (activo) {
            word = "Agregagaste ${alumno.nombre} al carrito"
        } else {
            word = "Agregar al carrito"
        }
        activo = !activo
    }
//    var imagen: Int = R.drawable.reyes
//    var nombre: String = "Macbook Pro:"
//    var calificacion: Float = 4.8f
//    var precio: Int = 12998
//    var diaDeLlegada: String = "viernes"
    Card(modifier = Modifier.fillMaxWidth().padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = alumno.color
        )) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
                Column() {
                    Text(text = alumno.count.toString(), modifier = Modifier.padding(6.dp))
                    Image(
                        painter = painterResource(id = alumno.imagen),
                        contentDescription = "imagen cool",
                        modifier = Modifier.size(size = 100.dp)
                            .clip(CircleShape)
                    )
                }


                Column(modifier = Modifier.padding(4.dp)) {
                    Text(text = alumno.nombre, fontSize = 20.sp)
                    Text(text = "Promedio general: " + alumno.calificacion, fontSize = 13.sp)
                    Text(text = "Correo: " + alumno.correo, fontSize = 13.sp)
                    Text(text = "Carrera: " + alumno.carrera, fontSize = 13.sp)
                    Text(text = "ID:  " + alumno.id, fontSize = 13.sp)

                    Spacer(modifier = Modifier.size(10.dp))

                }
            }
        }
    }
}






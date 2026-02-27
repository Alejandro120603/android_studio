package com.example.actividad1am.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun FilaView() {
    Row( // Row organiza elementos horizontalmente
        modifier = Modifier.fillMaxWidth(), // La fila ocupa todo el ancho disponible

        horizontalArrangement = Arrangement.SpaceAround
        // Distribuye los elementos con espacio alrededor de cada uno
    ) {
        // Llama a otro composable que muestra texto con color
        TextoConColor()
        // Texto normal con tamaño 20sp
        Text(text = "Primero", fontSize = 20.sp)
        Text(text = "Segundo", fontSize = 20.sp)
        Text(text = "Tercero", fontSize = 20.sp)
    }
}

@Preview
@Composable
fun DividerHorizontal() {
    Column {
        Text("Primero")
        Divider()   // Línea horizontal
        Text("Segundo")
        Divider( //personalizado
            color = Color.Red,
            thickness = 2.dp
        )
        Text("Tercero")
    }
}

@Preview
@Composable
fun DividerVertical() {
    Row { // Row organiza los elementos horizontalmente
        Text("Izquierda") // Texto que aparece del lado izquierdo

        Divider(   // Línea divisoria vertical
            modifier = Modifier
                .height(200.dp) // Altura de la línea
                .width(1.dp)    // Grosor de la línea (muy delgada)
        )
        Text("Derecha")    // Texto que aparece del lado derecho
    }
}

@Preview(showBackground = true)
@Composable
fun TablaEjemplo() {

    // Column organiza elementos en forma vertical (como una lista)
    Column(
        modifier = Modifier
            .fillMaxSize()   // Ocupa todo el tamaño de la pantalla
            .padding(16.dp)  // Agrega espacio interno alrededor (margen interno)
    ) {

        // ENCABEZADO DE LA TABLA 
        Row(
            modifier = Modifier.fillMaxWidth(), // La fila ocupa todo el ancho
            horizontalArrangement = Arrangement.SpaceEvenly // Distribuye los elementos con el mismo espacio entre ellos
        ) {
            // Texto en negrita
            Text("Nombre", fontWeight = FontWeight.Black)
            Text("Apellido", fontWeight = FontWeight.Bold)
        }

        // Línea separadora horizontal
        Divider(thickness = 1.dp)

        // FILAS DE DATOS
        FilaAlumno("Jhon", "Smith")
        FilaAlumno("Tanaka", "Jotaro")
        FilaAlumno("Alexander", "Heidenberg")
        FilaAlumno("Laura", "Hernandez")
        FilaAlumno("Daniel", "Olvera")
    }
}


// Función reutilizable para crear cada fila de la tabla
@Composable
fun FilaAlumno(nombre: String, apellido: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()          // La fila ocupa todo el ancho
            .padding(vertical = 8.dp), // Espacio arriba y abajo
        horizontalArrangement = Arrangement.SpaceEvenly
        // Espacio uniforme entre columnas
    ) {
        Text(nombre) // Muestra el nombre recibido como parámetro
        Text(apellido)// Muestra el apellido recibido como parámetro
    }
    Divider()   // Línea separadora después de cada fila
}

@Preview(showBackground = true)
@Composable
fun practicavertical(){
Row {
    Text("Izquierda")
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
    )
    Text("Derecha")
}
}

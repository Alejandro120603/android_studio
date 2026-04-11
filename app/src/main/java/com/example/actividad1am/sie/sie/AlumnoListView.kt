package com.example.moviles.sie

import com.example.moviles.ui.theme.ProductViewModel
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun ListView2(selectMaster: Int) {
    val Brown = Color(0x61865200)
    val productVM = AlumnoViewModel()
    var estado by remember { mutableStateOf(0) }
    var contador by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.padding(30.dp)) {

            items(items = productVM.getAlumnos(select = selectMaster)) { alumno ->
                contador += 1
                alumno.count = contador
                if (alumno.count%2 == 0) {
                    alumno.color = Color.LightGray
                } else {
                    alumno.color = Brown
                }
                AlumnoView(alumno, selected = {
                    Log.d("EVENTO", "provando el evento del producto")
                    estado = 1
                })
            }

        }
    }
}
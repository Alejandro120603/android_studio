package com.example.actividad1am.corrutinas

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun WinnerPreview(){
    WinnerView(StudentsViewModel())
}

@Composable
fun WinnerView(studentVM: StudentsViewModel){

    var nombre by remember { mutableStateOf(value = "") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Sorteo alumnos")

        TextField(
            value = nombre,
            onValueChange = {
                nombre = it
            }
        )
        Button(onClick = {
            studentVM.getWinner()
        }) {
            Text(text = "Comenzar")
        }

       // CircularProgressIndicator(modifier = gfv)
        if (studentVM.isLoading) {
            CircularProgressIndicator()
            Text("Cargando porfavor espere")
        }else{
            Text("El ganador es.... ${studentVM.winner}")
        }

        Text(text = "El ganador es.... ${studentVM.winner}")
    }
}
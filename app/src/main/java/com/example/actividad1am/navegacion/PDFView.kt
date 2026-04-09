package com.example.actividad1am.navegacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// @Preview (showBackground = true)
@Composable
fun PDFView(generarReporte: ReportModel) {

    Column(modifier = Modifier.fillMaxSize()) {

        Text(text = "Nombre de la sección:${generarReporte.nombreSeccion}")
        Text(text = "Numero de la sección:${generarReporte.numeroSeccion}")
        Text(text = "Nombre del encargado:${generarReporte.nombreEncargado}")

    }

    @Composable

    fun PDFPreView(){
        val reporte = ReportModel(1, nombreEncargado = "Juan", nombreSeccion = "xd")
        PDFView(generarReporte = reporte)
    }

}
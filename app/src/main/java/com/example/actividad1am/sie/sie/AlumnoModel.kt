package com.example.moviles.sie

import androidx.compose.ui.graphics.Color

data class AlumnoModel(
    var nombre: String,
    val imagen: Int,
    var color: Color,
    var count: Int,
    val calificacion: Float,
    val id: Int,
    val correo: String,
    val carrera: String
)

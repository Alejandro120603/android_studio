package com.example.actividad1am.hoteleria

data class HoteleriaDatos(
    val nombre: String,
    val puntuacion: String,
    val precio: String,
    val ubicacion: String,
    val imagen: Int,
    val select: Int
)

data class HoteleriaReservaDatos(
    val nombre: String,
    val telefono: String
)

package com.example.actividad1am.hoteleria

import com.example.actividad1am.R

class HoteleriaProvider {

    fun getHoteles(): List<HoteleriaDatos> {
        //Aquí cargamos los 6 hoteles que vamos a usar
        return listOf(
            HoteleriaDatos(
                nombre = "Hotel Centro Nice",
                puntuacion = "4.8",
                precio = "$1,200",
                ubicacion = "Centro de Monterrey",
                imagen = R.drawable.hotel1,
                select = 1
            ),
            HoteleriaDatos(
                nombre = "Hotel Vista Mar",
                puntuacion = "4.7",
                precio = "$1,450",
                ubicacion = "Zona playa",
                imagen = R.drawable.hotel2,
                select = 2
            ),
            HoteleriaDatos(
                nombre = "Hotel Sol House",
                puntuacion = "4.6",
                precio = "$1,100",
                ubicacion = "Cerca del centro",
                imagen = R.drawable.hotel3,
                select = 3
            ),
            HoteleriaDatos(
                nombre = "Hotel Luna Stay",
                puntuacion = "4.9",
                precio = "$1,700",
                ubicacion = "Zona premium",
                imagen = R.drawable.hotel4,
                select = 4
            ),
            HoteleriaDatos(
                nombre = "Hotel Garden Place",
                puntuacion = "4.5",
                precio = "$980",
                ubicacion = "Avenida principal",
                imagen = R.drawable.hotel5,
                select = 5
            ),
            HoteleriaDatos(
                nombre = "Hotel Sky Rooms",
                puntuacion = "4.4",
                precio = "$1,050",
                ubicacion = "Zona norte",
                imagen = R.drawable.hotel6,
                select = 6
            )
        )
    }

    fun getHotel(select: Int): HoteleriaDatos? {
        //Con esto buscamos cuál hotel se seleccionó
        return getHoteles().find { hotel ->
            hotel.select == select
        }
    }
}

class HoteleriaReservaProvider {

    fun getReservaVacia(): HoteleriaReservaDatos {
        //Solo regresa la info vacía para iniciar el form
        return HoteleriaReservaDatos(
            nombre = "",
            telefono = ""
        )
    }
}
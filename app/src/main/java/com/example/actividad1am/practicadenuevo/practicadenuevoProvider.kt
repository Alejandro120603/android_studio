package com.example.actividad1am.practicadenuevo

import com.example.actividad1am.R

class practicadenuevoProvider {

    fun getCuentas(): List<practicadenuevoDatos> {
        //Aquí cargamos las dos cuentas de prueba
        val cuenta1 = practicadenuevoDatos(
            "cuenta1",
            "1111",
            "Daniel Alejandro",
            23,
            R.drawable.amir,
            1
        )

        val cuenta2 = practicadenuevoDatos(
            "cuenta2",
            "2222",
            "Misael Olvera",
            22,
            R.drawable.gustambo,
            2
        )

        return listOf(cuenta1, cuenta2)
    }

    fun getPerfil(select: Int): practicadenuevoDatos? {
        //Con esto buscamos el perfil que toca según el select
        return getCuentas().find { cuenta ->
            cuenta.select == select
        }
    }

    fun getAmigos(select: Int): List<practicadenuevoAmigoDatos> {
        //Se separan por cuenta para que cada perfil tenga sus cards abajo
        return if (select == 1) {
            listOf(
                practicadenuevoAmigoDatos(
                    "Antonio",
                    24,
                    R.drawable.sergio_canales
                ),
                practicadenuevoAmigoDatos(
                    "Amir",
                    23,
                    R.drawable.amir
                ),
                practicadenuevoAmigoDatos(
                    "Adrian",
                    22,
                    R.drawable.nino
                )
            )
        } else if (select == 2) {
            listOf(
                practicadenuevoAmigoDatos(
                    "Myrna",
                    21,
                    R.drawable.myrna
                ),
                practicadenuevoAmigoDatos(
                    "Jaimito",
                    20,
                    R.drawable.gustambo
                ),
                practicadenuevoAmigoDatos(
                    "Chuy",
                    24,
                    R.drawable.sergio_canales
                )
            )
        } else {
            emptyList()
        }
    }
}

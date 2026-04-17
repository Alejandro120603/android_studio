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
}

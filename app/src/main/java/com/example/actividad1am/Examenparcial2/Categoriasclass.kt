package com.example.actividad1am.examenparcial2

import com.example.actividad1am.R

class Categoriasclass {

    fun getDragones(): List<CategoriasDatos> {
        //Aquí cargamos los dragones de la lista
        val dragon1 = CategoriasDatos(
            nombre = "Trueno Tambor",
            clase = "Marejada",
            imagen = R.drawable.trueno01,
            select = 1
        )

        val dragon2 = CategoriasDatos(
            nombre = "Cortaleña",
            clase = "Afilada",
            imagen = R.drawable.cortalena01,
            select = 2
        )

        val dragon3 = CategoriasDatos(
            nombre = "Caldero",
            clase = "Marejada",
            imagen = R.drawable.caldero01,
            select = 3
        )

        val dragon4 = CategoriasDatos(
            nombre = "Metamórfala",
            clase = "Misterio",
            imagen = R.drawable.metamorfala01,
            select = 4
        )

        val dragon5 = CategoriasDatos(
            nombre = "Muerte Susurrante",
            clase = "Piedra",
            imagen = R.drawable.muerte01,
            select = 5
        )

        val dragon6 = CategoriasDatos(
            nombre = "Furia Nocturna",
            clase = "Embestida",
            imagen = R.drawable.furia01,
            select = 6
        )

        return listOf(dragon1, dragon2, dragon3, dragon4, dragon5, dragon6)
    }
}

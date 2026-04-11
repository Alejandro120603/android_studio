package com.example.actividad1am.ActList

import com.example.actividad1am.R

class ActListCategorias {

    fun getCategorias(): List<ActListDatos> {

        val aves = ActListDatos("Aves", R.drawable.aves, 1)
        val perros = ActListDatos("Perros", R.drawable.perros, 2)
        val reptiles = ActListDatos("Reptiles", R.drawable.reptiles, 3)
        val anfibios = ActListDatos("Anfibios", R.drawable.anfibios, 4)
        val gatos = ActListDatos("Gatos", R.drawable.gatos, 5)

        return listOf(aves, perros, reptiles, anfibios, gatos)
    }
}
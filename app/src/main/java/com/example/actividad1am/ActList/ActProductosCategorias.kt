package com.example.actividad1am.ActList

import com.example.actividad1am.R

class ActProductosCategorias {

    fun getProductos(select: Int): List<ActProductoDatos> {

        return when (select) {

            1 -> listOf(
                ActProductoDatos("Agaporni", "$850", R.drawable.aves1, true, "10% OFF"),
                ActProductoDatos("Picozapato", "$10450", R.drawable.aves2, false, ""),
                ActProductoDatos("ninfa", "$1200", R.drawable.aves3, true, ""),
                ActProductoDatos("Loro cabeza amarilla", "$3650", R.drawable.aves4, false, ""),
                ActProductoDatos("cacatua", "$1120", R.drawable.aves5, true, "")
            )

            2 -> listOf(
                ActProductoDatos("Perro gordo", "$2500", R.drawable.perros1, true, "15% OFF"),
                ActProductoDatos("Perro nerd", "$1800", R.drawable.perros2, false, ""),
                ActProductoDatos("Perro rudo", "$3200", R.drawable.perros3, true, ""),
                ActProductoDatos("miniperro", "$650", R.drawable.perros4, true, ""),
                ActProductoDatos("Grandanes", "$1800", R.drawable.perros5, false, "")
            )

            3 -> listOf(
                ActProductoDatos("Iguana verde", "$11500", R.drawable.reptiles1, true, "20% OFF"),
                ActProductoDatos("Serpiente azul", "$21300", R.drawable.reptiles2, false, ""),
                ActProductoDatos("Dragon de komodo", "$6900", R.drawable.reptiles3, true, ""),
                ActProductoDatos("Abronia", "$1700", R.drawable.reptiles4, false, ""),
                ActProductoDatos("Camaleon velo", "$2700", R.drawable.reptiles5, true, "")
            )

            4 -> listOf(
                ActProductoDatos("Rana arborícola", "$200", R.drawable.anfibios1, true, "5% OFF"),
                ActProductoDatos("Salamandra Negra", "$1200", R.drawable.anfibios2, false, ""),
                ActProductoDatos("Sapo", "$50", R.drawable.anfibios3, true, ""),
                ActProductoDatos("Ajolote lindi", "$10000", R.drawable.anfibios4, false, ""),
                ActProductoDatos("Salamandra rara", "$2500", R.drawable.anfibios5, true, "")
            )

            5 -> listOf(
                ActProductoDatos("Gato persa", "$2200", R.drawable.gatos1, true, "10% OFF"),
                ActProductoDatos("Gato gordo", "$2100", R.drawable.gatos2, false, ""),
                ActProductoDatos("Gato cute", "$3500", R.drawable.gatos3, true, ""),
                ActProductoDatos("gato negro", "$2220", R.drawable.gatos4, false, ""),
                ActProductoDatos("Gato raro", "$50", R.drawable.gatos5, true, "")
            )

            else -> emptyList()
        }
    }

    fun getTitulo(select: Int): String {
        return when (select) {
            1 -> "Aves"
            2 -> "Perros"
            3 -> "Reptiles"
            4 -> "Anfibios"
            5 -> "Gatos"
            else -> "Productos"
        }
    }
}
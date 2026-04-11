package com.example.moviles.sie

import androidx.compose.ui.graphics.Color
import com.example.actividad1am.R


class AlumnoViewModel {
    fun getAlumnos(select: Int): List<AlumnoModel> {
        var productList = mutableListOf<AlumnoModel>()
        productList.add(
            AlumnoModel(
                imagen = R.drawable.gustambo,
                nombre = "Gustavo Antonio",
                calificacion = 8.8f,
                count = 0,
                color = Color.LightGray,
                id = 20050,
                correo = "gustavo.perales@iest.edu.mx",
                carrera = "ISND"
            ),
        )

        productList.add(
            AlumnoModel(
                imagen = R.drawable.amir,
                nombre = "Jesus Adrian Perez Ramos",
                calificacion = 10f,
                count = 0,
                color = Color.LightGray,
                id = 20051,
                correo = "jesus.perez03@iest.edu.mx",
                carrera = "ISND"
            ),
        )

        productList.add(
            AlumnoModel(
                imagen = R.drawable.myrna,
                nombre = "Myrna Esther",
                calificacion = 9.5f,
                count = 0,
                color = Color.LightGray,
                id = 20052,
                correo = "myrna.leal@iest.edu.mx",
                carrera = "IQ"
            ),
        )
        when (select) {
            1 -> return productList

            3 -> return listOf(productList[1])

            4 -> return listOf(productList[2])

            else -> {return listOf(productList[0])}


        }

        return productList


    }
}
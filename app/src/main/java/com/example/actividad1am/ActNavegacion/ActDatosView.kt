package com.example.actividad1am.ActNavegacion

import androidx.compose.ui.graphics.Color
import com.example.actividad1am.R

class ActDatosView {

    fun getPersona(select: Int): ActNavdatos {

        val nino = ActNavdatos(
            imagen = R.drawable.nino,
            etapa = "Niñez",
            mensaje = "14 años o menos - menor de edad",
            color = Color.Black
        )

        val joven15 = ActNavdatos(
            imagen = R.drawable.amir,
            etapa = "Juventud",
            mensaje = "15 años - mayor de edad en Indonesia pero no en México",
            color = Color.Yellow
        )

        val joven16 = ActNavdatos(
            imagen = R.drawable.amir,
            etapa = "Juventud",
            mensaje = "16 años - mayor de edad en Cuba pero no en México",
            color = Color.Yellow
        )

        val joven17 = ActNavdatos(
            imagen = R.drawable.amir,
            etapa = "Juventud",
            mensaje = "17 años - mayor de edad en Corea del Norte pero no en México",
            color = Color.Yellow
        )

        val joven18 = ActNavdatos(
            imagen = R.drawable.amir,
            etapa = "Juventud",
            mensaje = "18 años - mayor de edad en México y gran parte de Latinoamérica",
            color = Color.Yellow
        )

        val joven19 = ActNavdatos(
            imagen = R.drawable.amir,
            etapa = "Juventud",
            mensaje = "19 años - mayor de edad en Corea del Sur",
            color = Color.Yellow
        )

        val joven20 = ActNavdatos(
            imagen = R.drawable.amir,
            etapa = "Juventud",
            mensaje = "20 años - mayor de edad en Japón",
            color = Color.Yellow
        )

        val joven21 = ActNavdatos(
            imagen = R.drawable.amir,
            etapa = "Juventud",
            mensaje = "21 años - mayor de edad en USA y posiblemente en todo el mundo",
            color = Color.Yellow
        )

        val jovenGeneral = ActNavdatos(
            imagen = R.drawable.amir,
            etapa = "Juventud",
            mensaje = "22 a 59 años - joven",
            color = Color.Yellow
        )

        val adultoMayor = ActNavdatos(
            imagen = R.drawable.terceraedad,
            etapa = "Tercera edad",
            mensaje = "60 años o más",
            color = Color.LightGray
        )

        val adultoMayor60 = ActNavdatos(
            imagen = R.drawable.terceraedad,
            etapa = "Tercera edad",
            mensaje = "60 años - eres de la tercera edad",
            color = Color.LightGray
        )

        val adultoMayor65 = ActNavdatos(
            imagen = R.drawable.terceraedad,
            etapa = "Tercera edad",
            mensaje = "65 años - ya te puedes jubilar",
            color = Color.LightGray
        )

        val adultoMayorGeneral = ActNavdatos(
            imagen = R.drawable.terceraedad,
            etapa = "Tercera edad",
            mensaje = "Más de 65 años - adulto mayor",
            color = Color.LightGray
        )

        return when (select) {
            in 0..14 -> nino
            15 -> joven15
            16 -> joven16
            17 -> joven17
            18 -> joven18
            19 -> joven19
            20 -> joven20
            21 -> joven21
            in 22..59 -> jovenGeneral
            60 -> adultoMayor60
            65 -> adultoMayor65
            in 61..64 -> adultoMayorGeneral
            in 66..150 -> adultoMayorGeneral
            else -> nino
        }
    }
}
package com.example.actividad1am.examenparcial2

import com.example.actividad1am.R

class DragonInformacionClass {

    fun getDragonesInformacion(): List<DragonInformacionDatos> {
        val dragon1 = DragonInformacionDatos(
            nombre = "Trueno Tambor",
            apodo = "Thornado",
            entrenable = true,
            clase = "Marejada",
            descripcion = "Este solitario dragón habita en cuevas y estanques marinos, si se le molesta puede producir un golpe de sonido que mata hombres a corta distancia",
            recomendacion = "Tirar a matar",
            nivelPeligro = "En extremo peligroso",
            imagenPrincipal = R.drawable.trueno01,
            imagenDetalle = R.drawable.trueno02,
            imagenClase = R.drawable.marejeada,
            select = 1
        )

        val dragon2 = DragonInformacionDatos(
            nombre = "Cortaleña",
            apodo = "Trepatroncos",
            entrenable = true,
            clase = "Afilada",
            descripcion = "Esta enorme criatura tiene alas afiladas que pueden cortar árboles maduros",
            recomendacion = "Tirar a matar",
            nivelPeligro = "En extremo peligroso",
            imagenPrincipal = R.drawable.cortalena01,
            imagenDetalle = R.drawable.cortalena02,
            imagenClase = R.drawable.afilada,
            select = 2
        )

        val dragon3 = DragonInformacionDatos(
            nombre = "Caldero",
            apodo = "Scauldy",
            entrenable = true,
            clase = "Marejada",
            descripcion = "Rocía agua hirviendo a sus víctimas",
            recomendacion = "Portar escudo y tirar a matar",
            nivelPeligro = "En extremo peligroso",
            imagenPrincipal = R.drawable.caldero01,
            imagenDetalle = R.drawable.caldero02,
            imagenClase = R.drawable.marejeada,
            select = 3
        )

        val dragon4 = DragonInformacionDatos(
            nombre = "Metamórfala",
            apodo = "",
            entrenable = false,
            clase = "Misterio",
            descripcion = "Recién salidos del huevo ya rocían ácido",
            recomendacion = "Tirar a matar",
            nivelPeligro = "Sumamente peligroso",
            imagenPrincipal = R.drawable.metamorfala01,
            imagenDetalle = R.drawable.metamorfala02,
            imagenClase = R.drawable.misterio,
            select = 4
        )

        val dragon5 = DragonInformacionDatos(
            nombre = "Muerte Susurrante",
            apodo = "Dientes",
            entrenable = false,
            clase = "Piedra",
            descripcion = "Asfixia a sus víctimas, las entierra, las quema, las voltea como a calcetines",
            recomendacion = "Tirar a matar",
            nivelPeligro = "En extremo peligroso",
            imagenPrincipal = R.drawable.muerte01,
            imagenDetalle = R.drawable.muerte02,
            imagenClase = R.drawable.piedra,
            select = 5
        )

        val dragon6 = DragonInformacionDatos(
            nombre = "Furia Nocturna",
            apodo = "Chimuelo",
            entrenable = true,
            clase = "Embestida",
            descripcion = "Rapidez: Desconocida. Tamaño: Desconocido. La cría maligna del relámpago y la muerte misma. Nunca enfrentar a este dragón.",
            recomendacion = "Tu única salida: esconderte e implorar que no te encuentre",
            nivelPeligro = "S+++",
            imagenPrincipal = R.drawable.furia01,
            imagenDetalle = R.drawable.furia02,
            imagenClase = R.drawable.embestida,
            select = 6
        )

        return listOf(dragon1, dragon2, dragon3, dragon4, dragon5, dragon6)
    }

    fun getDragonPorSelect(select: Int): DragonInformacionDatos? {
        //Aquí buscamos el dragón correcto para abrir su detalle
        return getDragonesInformacion().firstOrNull { it.select == select }
    }
}

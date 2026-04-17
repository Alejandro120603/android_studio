package com.example.actividad1am.parcial2repaso

import com.example.actividad1am.parcial2repaso.Parcial2datos
import com.example.actividad1am.R

//definimos el nombre de la clase
class parcial2hermanos {
    //Esa función sirve para: juntar tus datosn, devolverlos en forma de lista , usarlos luego en la interfaz
    fun getHermanos(): List<Parcial2datos> {
        //Aqui seleccionamos los datos a mostrar
        val Mediano = Parcial2datos("Daniel", 22, R.drawable.reptiles, 1)
        val Grande = Parcial2datos("Misael", 25, R.drawable.perros, 2)
        val Chico = Parcial2datos("Diego", 17, R.drawable.aves1, 3)
        //Esto retorna lo que se piensa enviar
        return listOf(Mediano,Grande,Chico)
    }
}
package com.example.moviles.sie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object Home2

@Serializable
object Error

@Serializable
data class EstudianteEscuela(
    val userId: Int,
    val userName: String
)

@Serializable
data class Materias(
    val calif: Float
)

@Serializable
object Report

@Serializable
data class CoordEscuela(
    val userId: Int,
    val userName: String
)

@Preview(showBackground = true)
@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home2
    ) {
        composable<Home2> {
            EscuelaView(navController)
        }

        composable<CoordEscuela> {
            val datos: CoordEscuela = it.toRoute()
            StatsView(datos)
        }

        composable<Error> {
            ErrorView(navController)
        }

        composable<EstudianteEscuela> {
            val datos2: EstudianteEscuela = it.toRoute()
            StatsStudentView(datos2, navController)
        }

        composable<Materias> {
            val datosMateria: Materias = it.toRoute()
            MateriaInfo(datosMateria, navController)
        }
    }
}
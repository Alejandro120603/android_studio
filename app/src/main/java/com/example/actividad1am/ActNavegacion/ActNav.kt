package com.example.actividad1am.ActNavegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

// ruta de la pantalla principal
@Serializable
object Home2

// ruta de la pantalla final
// aquí mandamos el select para saber qué resultado mostrar
@Serializable
data class Resultado(val select: Int)

@Preview(showBackground = true)
@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home2
    ) {
        // pantalla principal
        composable<Home2> {
            ActForm(navController)
        }

        // pantalla final
        composable<Resultado> {
            val datos: Resultado = it.toRoute()
            ResultadoView(select = datos.select, navController = navController)
        }
    }
}
package com.example.actividad1am.examenparcial2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad1am.R

@Composable
fun examenparcial2View() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicioLibro"
    ) {
        composable("inicioLibro") {
            PantallaInicialLibro(navController)
        }

        composable("listadoDeDragones") {
            ListadoDeDragones(
                cerrarLibro = {
                    navController.popBackStack()
                },
                abrirInformacion = { select ->
                    navController.navigate("informacionDragon/$select")
                }
            )
        }

        composable("informacionDragon/{select}") { backStackEntry ->
            val select = backStackEntry.arguments?.getString("select")?.toIntOrNull() ?: 0

            InformacionDragonView(
                select = select,
                regresar = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun PantallaInicialLibro(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.libro),
            contentDescription = "Libro",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        //Este boton abre la siguiente pantalla con navhost
        OutlinedButton(
            onClick = {
                navController.navigate("listadoDeDragones")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            )
        ) {
            Text("Abrir")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun examenparcial2ViewPreview() {
    MaterialTheme {
        examenparcial2View()
    }
}

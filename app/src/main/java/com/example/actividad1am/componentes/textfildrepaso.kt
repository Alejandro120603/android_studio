import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true) // Muestra vista previa en Android Studio
@Composable // Indica que esta función crea UI
fun CalculadoraBasica() {

    // Variables de estado (guardan lo que escribe el usuario)
    // remember → mantiene el valor aunque la pantalla se redibuje
    // mutableStateOf → hace que Compose detecte cambios y actualice la UI
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("Resultado:") }

    Column(
        modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
        verticalArrangement = Arrangement.Center, // Centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
    ) {
        // INPUT 1
        TextField(
            value = numero1, // Lo que muestra el campo
            onValueChange = { numero1 = it }, // Se ejecuta cuando escribes
            label = { Text("Número 1") } // Texto flotante del campo
        )

        // INPUT 2
        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") }
        )

        // BOTÓN SUMAR
        Button(
            onClick = {

                // Convertimos el texto a número
                // toIntOrNull() evita que la app truene si está vacío
                val n1 = numero1.toIntOrNull() ?: 0
                val n2 = numero2.toIntOrNull() ?: 0

                // Guardamos el resultado
                resultado = "Resultado: ${n1 + n2}"
            }
        ) {
            Text("Sumar") // Texto dentro del botón
        }

        // BOTÓN RESTAR
        Button(
            onClick = {

                val n1 = numero1.toIntOrNull() ?: 0
                val n2 = numero2.toIntOrNull() ?: 0

                resultado = "Resultado: ${n1 - n2}"
            }
        ) {
            Text("Restar")
        }


        Text(text = resultado)
    }
}
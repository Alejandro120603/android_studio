package com.example.actividad1am

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.actividad1am.api.DogView
import com.example.actividad1am.api.DogViewModel
import com.example.actividad1am.componentes.TextoCompletoView
import com.example.actividad1am.componentes.TextoDecoradoView
import com.example.actividad1am.componentes.TextoRepaso
import com.example.actividad1am.componentes.TextoRepaso
import com.example.actividad1am.corrutinas.WinnerView
import com.example.actividad1am.persistencia.ProfileView
import com.example.actividad1am.ui.theme.Actividad1AMTheme
import com.example.actividad1am.ActNavegacion.NavManager



class MainActivity : ComponentActivity() {

    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad1AMTheme {
                DogView(DogViewModel())
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, myTextView: Unit) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Actividad1AMTheme {
        Greeting("Android", myTextView = TextoCompletoView())
    }

}

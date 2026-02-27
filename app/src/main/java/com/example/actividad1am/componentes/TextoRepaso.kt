package com.example.actividad1am.componentes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TextoRepaso() {

    val frase = "Tres tristes tigres tragaban trigo en un trigal, en un trigal tres tristes tigres tragaban trigo"
    // Variable que guarda el texto a mostrar
    Text( // Componente que muestra texto en pantalla
        text = frase, // Texto que se va a imprimir
        color = Color.Red, // Cambia el color del texto
        fontSize = 32.sp, // Tamaño del texto
        fontStyle = FontStyle.Italic, // Inclinación (cursiva)
        fontWeight = FontWeight.Bold, // Grosor (negrita)
        fontFamily = FontFamily.Cursive, // Tipo de letra
        letterSpacing = 5.sp, // Espacio entre letras
        textDecoration = TextDecoration.Underline, // Subrayado
        textAlign = TextAlign.Justify, // Alineación justificada
        lineHeight = 45.sp, // Espacio entre líneas
        softWrap = true, // Permite salto automático de línea
        minLines = 10, // Mínimo de líneas que ocupará
        //maxLines = 5, // Máximo de líneas permitidas
        overflow = TextOverflow.Ellipsis // Agrega "..." si el texto se corta
    ) // Insertamos el texto
}
@Preview(showBackground = true) // Permite ver la vista previa en Android Studio con fondo
@Composable // Indica que esta función dibuja UI en Compose
fun TextShadow() {

    val offset = Offset(x = 5.0f, y = 10.0f)
    // Define la posición de la sombra (5 derecha, 10 abajo)
    Text( // Componente que muestra texto en pantalla
        text = "Hello world!", // Texto que se mostrará
        style = TextStyle( // Estilo personalizado del texto
            fontSize = 24.sp, // Tamaño del texto
            shadow = Shadow( // Agrega sombra al texto
                color = Color.Blue, // Color de la sombra
                offset = offset, // Posición de la sombra
                blurRadius = 3f // Nivel de difuminado de la sombra
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TextoConColor() {
    Text(
        text = "Adiós",
        color = Color(0xFFD726C6),
        fontWeight = FontWeight.Thin
    )
}

// fun Text(
//     text: String,
//     // Texto que se mostrará en pantalla.
//     modifier: Modifier = Modifier,
//     // Permite modificar el diseño: tamaño, padding, alineación, fondo, etc.
//     color: Color = Color.Unspecified,
//     // Color del texto.
//     fontSize: TextUnit = TextUnit.Unspecified,
//     // Tamaño del texto (por ejemplo 16.sp).
//     fontStyle: FontStyle? = null,
//     // Estilo de fuente: normal o itálica.
//     fontWeight: FontWeight? = null,
//     // Grosor del texto: Bold, Thin, Light, etc.
//     fontFamily: FontFamily? = null,
//     // Tipo de fuente (Arial, Serif, Monospace, etc).
//     letterSpacing: TextUnit = TextUnit.Unspecified,
//     // Espacio entre letras.
//     textDecoration: TextDecoration? = null,
//     // Decoración del texto: subrayado, tachado, etc.
//     textAlign: TextAlign? = null,
//     // Alineación del texto: Start, Center, End, Justify.
//     lineHeight: TextUnit = TextUnit.Unspecified,
//     // Altura entre líneas.
//     overflow: TextOverflow = TextOverflow.Clip,
//     // Qué pasa si el texto es muy largo (cortar, puntos suspensivos, etc).
//     softWrap: Boolean = true,
//     // Permite que el texto salte a la siguiente línea automáticamente.
//     maxLines: Int = Int.MAX_VALUE,
//     // Número máximo de líneas permitidas.
//     minLines: Int = 1,
//     // Número mínimo de líneas que ocupará el texto.
//     onTextLayout: ((TextLayoutResult) -> Unit)? = null,
//     // Función que se ejecuta cuando el texto termina de dibujarse.
//     style: TextStyle = LocalTextStyle.current
//     // Estilo general del texto (puede combinar varios atributos)
// )

package com.example.actividad1am

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// importations


// codec
@Preview(showBackground = true)
@Composable
fun MyTextView() {
    Text(
        text = "Hola mi intento de realizarlo",
        color = Color.Blue,
        fontSize = 88.sp,
        fontWeight = FontWeight.Light,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 20.sp,
        lineHeight = 77.sp,
        textDecoration = TextDecoration.LineThrough,
        textAlign = TextAlign.Justify,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis
    )
}




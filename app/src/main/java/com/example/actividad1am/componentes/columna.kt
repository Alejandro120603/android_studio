package com.example.actividad1am.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad1am.ui.theme.MyTextView

@Preview(showBackground = true)
@Composable
fun Columnas(){
    Column(verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.background(Color.Red).padding(end = 100.dp),
        horizontalAlignment = Alignment.End
        ) {
        MyTextView()
        Text(text = "danicrack12")
        Spacer(modifier = Modifier.height(height = 20.dp))
        Text(text = "Amirpro95")
        Spacer(modifier = Modifier.height(height = 20.dp))
        Text(text = "XxxAdryxtupatronXxx")
        Spacer(modifier = Modifier.height(height = 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun Separadores(){
    Column(verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Mexico", modifier = Modifier.fillMaxSize().weight(weight = 25f))
        HorizontalDivider(thickness = 10.dp, color = Color.Red)
        Text(text = "Lindo", modifier = Modifier.fillMaxSize().weight(weight = 50f))
        Text(text = "Hermoso", modifier = Modifier.fillMaxSize().weight(weight = 75f))
        Text(text = "Bello", modifier = Modifier.fillMaxSize().weight(weight = 100f))
        Columnas()
    }
}
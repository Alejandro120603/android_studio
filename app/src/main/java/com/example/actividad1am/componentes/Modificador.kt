package com.example.actividad1am.componentes

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividad1am.ui.theme.Pink40


@Preview(showBackground = true)
@Composable
fun Modificador () {
    Text(
        text = "hola Amir buenas noches",
        modifier = Modifier
            //.fillMaxHeight()
            .background(Color(color = 0xFFE91E63))
            .padding(7.dp)
            //.background(Color.White)
            .padding(vertical = 14.dp)
            //alpha(alpha = 0.5f)
            //.blur(radius = 0.8.dp)
            .border(width = 2.dp, Color.DarkGray)
            .shadow(elevation = 20.dp)
            .rotate(degrees = 190f),
        color = Pink40,
        fontSize = 12.sp


    )
}
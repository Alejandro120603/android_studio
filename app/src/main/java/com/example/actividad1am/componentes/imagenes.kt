package com.example.actividad1am.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad1am.R

@Preview(showBackground = true)
@Composable

fun imagenes(){
    Column(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id= R.drawable.gustambo),
            contentDescription = "foto de trex",
            modifier = Modifier.size(200.dp).clip(CircleShape),
            contentScale = ContentScale.FillHeight)

        Icon(painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = null,
            tint = Color(0xFFEA2222)
        )

        Icon(imageVector = Icons.Filled.Egg
            , contentDescription = "huevos"

        )


    }
}
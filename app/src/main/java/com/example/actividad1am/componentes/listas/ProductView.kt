package com.example.actividad1am.componentes.listas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividad1am.R
import java.nio.file.WatchEvent

@Preview(showBackground = true)
@Composable
fun ProductView(){
    Card(modifier = Modifier.fillMaxWidth().padding(all = 10.dp)) {
        Column(modifier = Modifier.fillMaxWidth())  {
            Row() {
                Image(painter = painterResource(id = R.drawable.amir),
                    contentDescription = "imagen cool",
                    modifier = Modifier.size(size = 150.dp).align(Alignment.CenterVertically))
                Column(modifier = Modifier.padding(all = 10.dp)) {
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = "CUIDADO ES UN:", fontSize = 30.sp)
                    Text(text = "\uD83D\uDE08 INFIEL" , fontSize = 15.sp)
                    Text(text = "\uD83D\uDE23 MANIPULADOR" , fontSize = 15.sp)
                    Text(text = "\uD83D\uDC94 ROMPECORAZONES", fontSize = 15.sp)
                    Text(text = "\uD83D\uDD25 \uD83D\uDD25 \uD83D\uDD25EXTREMADAMENTE GUAPO \uD83D\uDD25 \uD83D\uDD25 \uD83D\uDD25", fontSize = 20.sp, fontWeight =  FontWeight.Bold)
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(
                        Color.Yellow,
                        contentColor = Color.Black))
                    {Text(text = "Funar anonimamente")
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                }
            }
        }
    }

}
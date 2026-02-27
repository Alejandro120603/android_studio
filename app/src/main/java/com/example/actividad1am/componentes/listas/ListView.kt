package com.example.actividad1am.componentes.listas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.actividad1am.R
import com.example.moviles.ui.theme.ProductViewModel

@Preview(showBackground = true)
@Composable

fun ListaView(){

    val productiVM = ProductViewModel()
    Column(modifier = Modifier.fillMaxSize()){
        LazyColumn() {
            items( items = productiVM.getProducts() ){ producto ->
                ProductView(producto)

            }
        }
    }
    }


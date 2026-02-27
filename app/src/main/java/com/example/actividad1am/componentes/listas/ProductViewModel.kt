package com.example.moviles.ui.theme

import com.example.actividad1am.R


class ProductViewModel {
    fun getProducts() :List<ProductModel>{
        var productList = mutableListOf<ProductModel>()
        productList.add(ProductModel(imagen = R.drawable.amir,
            nombre = "uno:",
            calificacion = 4.8f,
            precio = 12998,
            diaDeLlegada = "viernes"))

        productList.add(ProductModel(imagen = R.drawable.bronto,
            nombre = "dos",
            calificacion = 4.8f,
            precio = 1000,
            diaDeLlegada = "jueves"))

        productList.add(ProductModel(imagen = R.drawable.gustambo,
            nombre = "tres",
            calificacion = 3.7f,
            precio = 60000,
            diaDeLlegada = "lunes"))

        productList.add(ProductModel(imagen = R.drawable.trex,
            nombre = "cuatro",
            calificacion = 4.3f,
            precio = 50000,
            diaDeLlegada = "miercoles"))

        productList.add(ProductModel(imagen = R.drawable.amir,
            nombre = "cinco",
            calificacion = 4.1f,
            precio = 1900,
            diaDeLlegada = "sabado"))

        productList.add(ProductModel(imagen = R.drawable.gustambo,
            nombre = "seis",
            calificacion = 3.5f,
            precio = 1090,
            diaDeLlegada = "jueves"))

        productList.add(ProductModel(imagen = R.drawable.amir,
            nombre = "siete",
            calificacion = 5.0f,
            precio = 19090,
            diaDeLlegada = "martes"))

        return productList
    }



}
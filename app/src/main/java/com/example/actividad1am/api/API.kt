package com.example.actividad1am.api

import android.util.Log

class API {
    private val service =
        RetrofitHelper.getRetrofitService()

    suspend fun getImagenAleatoria(): String {
        val response =
            service.imagenAleatoria()
        val msg: String
        if(response.body()?.status.equals("success")){
            msg = response.body()?.message ?: ""
        }else {
            msg = "Fail"
        }
        Log.d("API_PRUEBA", "status es " + response.body()?.status)
        Log.d("API_PRUEBA", "message es " + response.body()?.message)

        return msg
    }
}
package com.example.actividad1am.navegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object Report

@Serializable
data class ReportModel(
    val numeroSeccion : Int,
    val nombreEncargado : String,
    val nombreSeccion : String
)

@Preview(showBackground = true)
@Composable
fun NavManager() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = Home) {

        composable<Home> {
            HomeView(navegante = navController)
        }

        composable<Report> {
            ReportView(navegante = navController)
        }
        composable <ReportModel> {
            val datos: ReportModel = it.toRoute()
            PDFView(datos)
        }

    }
}
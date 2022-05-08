package com.example.aprendiendo.navigation

sealed class AppScreens(val ruta: String){

    object PantallaPrimera:AppScreens("primera_pantalla")
    object PantallaSegunda:AppScreens("segunda_pantalla")
}


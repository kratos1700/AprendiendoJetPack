package com.example.aprendiendo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aprendiendo.room.ui.PantallaRoom
import com.example.aprendiendo.room.ui.viewModel.PantallaRomViewModel
import com.example.aprendiendo.screens.PantallaPrimera
import com.example.aprendiendo.screens.PantallaSegunda

// tenemos que importar al gradle implementation('androidx.navigation:navigation-compose:2.4.2')

@Composable
fun AppNavigation(){
    val pantallaRomViewModel = PantallaRomViewModel()
    // gestiona el estado de navegacion de las pantallas
    val navController =  rememberNavController()
    // le pasamos el navController que hemos creado
    NavHost(navController = navController, startDestination = AppScreens.PantallaPrimera.ruta ){
        composable(route = AppScreens.PantallaPrimera.ruta){
            PantallaPrimera(navController)
        }
                                        // pasamos parametros a la segunda pantalla
        composable(route = AppScreens.PantallaSegunda.ruta + "/{text}",
            arguments = listOf(navArgument(name = "text"){
            type= NavType.StringType
        })){
            PantallaSegunda(navController, it.arguments?.getString("text")) // recuperamos el texto
        }

        composable(route = AppScreens.PantallaRoom.ruta){
            PantallaRoom(navController,pantallaRomViewModel)
        }
    }

}
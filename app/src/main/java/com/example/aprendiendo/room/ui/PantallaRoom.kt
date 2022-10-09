package com.example.aprendiendo.room.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaRoom(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar() {
            // añadimos icono
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="flecha de volver" ,
                modifier = Modifier.clickable { navController.popBackStack() })
            // añadimos espacio entre la flecha y el titulo del toolbar
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Pruebas con Room")

        }
    }) {

    }



}
package com.example.aprendiendo.room.ui

import android.annotation.SuppressLint
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.aprendiendo.room.AppDatabase
import com.example.aprendiendo.room.ui.viewModel.PantallaRomViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun PantallaRoom(navController: NavController, viewModel:PantallaRomViewModel) {
    //para crear coroutinas en JetPack
    val scope = rememberCoroutineScope()
    //recuperamos el contexto
    val context = LocalContext.current
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
       // AppDatabase.initDatabase(context = LocalContext.current)
       // rememberCoroutineScope()

        scope.launch {
            withContext(Dispatchers.IO){
                AppDatabase.initDatabase(context).query(SimpleSQLiteQuery("SELECT 1"))

            }

        }
    }



}
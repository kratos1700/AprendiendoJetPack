package com.example.aprendiendo.room.ui

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.aprendiendo.room.AppDatabase
import com.example.aprendiendo.room.database.entities.Alumno
import com.example.aprendiendo.room.ui.viewModel.PantallaRomViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun PantallaRoom(navController: NavController, viewModel: PantallaRomViewModel) {
    //para crear coroutinas en JetPack
    val scope = rememberCoroutineScope()
    //recuperamos el contexto
    val context = LocalContext.current
    // creamos la variable lifeCycleOwner para poder usar el observe del liveData
  val  lifeCycleOwner: LifecycleOwner = LocalLifecycleOwner.current

    Scaffold(topBar = {
        TopAppBar() {
            // añadimos icono
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "flecha de volver",
                modifier = Modifier.clickable { navController.popBackStack() })
            // añadimos espacio entre la flecha y el titulo del toolbar
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Pruebas con Room")

        }
    }) {
        // AppDatabase.initDatabase(context = LocalContext.current)
        // rememberCoroutineScope()
/*
        scope.launch {
            withContext(Dispatchers.IO){
                AppDatabase.initDatabase(context).query(SimpleSQLiteQuery("SELECT 1"))
            }
        }
 */
        // viewModel.saveAlumnos(Alumno("Miki", "Jairo", 22), context)

        viewModel.alumnos.observe(lifeCycleOwner){
            Log.d("ROOM", it.toString())
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd, ) {

            IconButton(onClick = {
                viewModel.saveAlumnosLive(Alumno("EOOOO", "Jairo", 22))
                    .observe(lifeCycleOwner) {
                        Toast.makeText(context, "El id creado es $it", Toast.LENGTH_LONG).show()
                    }
            }, modifier = Modifier.size(80.dp)) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar item",tint= Color.Blue,  modifier = Modifier.size(50.dp))
            }
        }
    }


}


/*
per a grafics
https://github.com/PhilJay/MPAndroidChart
 */
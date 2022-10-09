package com.example.aprendiendo.screens

import android.annotation.SuppressLint
import androidx.activity.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aprendiendo.logo
import com.example.aprendiendo.navigation.AppScreens


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrimera(navController: NavController){
    // nospermite usar los elementos basicos de Material Desing
    Scaffold(topBar = { // creamos un toolbar
        TopAppBar() {
            Text(text = "Primera Pantalla")
        }
    }) {
        //it.calculateBottomPadding().value
        BodyContent("Kratos1700", navController)
    }
}

@Composable
fun BodyContent(name : String, navController: NavController){
    MaterialTheme() {

        //pone un elemento encima de otro
        Column(
            // podemos usar modificadores
            //añadimos margenes   usamos el espacio total
            // aliniamos al centro
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // importamos una imagen i le damos un tamaño con el modificador


            Image(
                painter = painterResource(id = logo),
                contentDescription = "imagen perfil",
                modifier = Modifier.height(200.dp)
            )
            // damos espacio entre la imagen i texto
            Spacer(modifier = Modifier.height(15.dp))
            // usando la tipografia del material al la fuente con un h6
            Text(text = "Mi nombre es $name", style = MaterialTheme.typography.h6)
            Text(text = "Aprendiendo JetPack.")


            // damos espacio entre la texto i boton
            Spacer(modifier = Modifier.height(40.dp))
            // boton con bordes
            OutlinedButton(onClick = {
                                     navController.navigate(route = AppScreens.PantallaSegunda.ruta +
                                     "/envio un parametro desde la 1era pantalla")
                                     },
                border = BorderStroke(1.dp, Color.Blue),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "Ir Pantalla 2")


            }

            // damos espacio entre la texto i boton
            Spacer(modifier = Modifier.height(40.dp))

            // boton con bordes
            OutlinedButton(onClick = {
                navController.navigate(route = AppScreens.PantallaRoom.ruta)
            },
                border = BorderStroke(1.dp, Color.Blue),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "Ir Pruebas con Room")


            }
        }

    }

}

/**
 * Nos permite ver la vista interactiva
 */
/*
@Preview(showBackground = true)
@Composable
fun PreviewPersonalInfo() {

    PantallaPrimera()

}*/

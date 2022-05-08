package com.example.aprendiendo.screens

import androidx.activity.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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


@Composable  // recibimos el navcontroler y el parametro text opcional
fun PantallaSegunda(navController: NavController, text: String?){
    // nospermite usar los elementos basicos de Material Desing
    Scaffold(topBar = {
        TopAppBar() {
            // añadimos icono
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="flecha de volver" ,
            modifier = Modifier.clickable { navController.popBackStack() })
            // añadimos espacio entre la flecha y el titulo del toolbar
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Segunda pantalla")
            
        }
    }) {
        SegundoBodyContent(navController, text)
    }
}

@Composable
fun SegundoBodyContent(navController: NavController,text: String?){


    Row(modifier = Modifier.padding(16.dp)) {
        MyImagen()
        Mensajes()


    }
   Column(modifier = Modifier
       .padding(16.dp)
       .fillMaxWidth(),
       horizontalAlignment = Alignment.CenterHorizontally) {



       // damos espacio entre la texto i boton
       Spacer(modifier = Modifier.height(70.dp))
       Text(text = "He enviado el mensage de navegación")
       // si se recibe un texto lo comprovamos que no sea nulo para pintar su valor
       text?.let {
           Text(it)
       }
       // boton con bordes
       OutlinedButton(onClick = {
           navController.popBackStack()
                                },
           border = BorderStroke(1.dp, Color.Blue),
           shape = RoundedCornerShape(50)
       ) {
           Text(text = "Ir Pantalla 1")


       }
   }




}




@Composable
fun MyImagen(){
    Image(painterResource(id = com.example.aprendiendo.R.drawable.ic_launcher_foreground), contentDescription = "imagen android")
}


@Composable
fun Mensajes() {
    Column() {
        myTexto(text = "Usando JetPack Compose")
        myTexto(text = "trasteando...")
    }
}

@Composable
fun myTexto(text: String) {
    Text(text = text)

}




/**
 * Nos permite ver la vista interactiva
 */
/*
@Preview(showBackground = true)
@Composable
fun PreviewCardInfo() {

    PantallaSegunda()

}*/

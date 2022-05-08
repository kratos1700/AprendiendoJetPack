package com.example.aprendiendo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import com.example.aprendiendo.navigation.AppNavigation
import com.example.aprendiendo.screens.PantallaPrimera
import com.example.aprendiendo.ui.theme.AprendiendoTheme
val logo :Int = R.drawable.perfil;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          //  PersonalInfo("Kratos")
            // componente que se encarga de la navegacion
            AppNavigation()


        }
    }


    // no se muestra en este ejemplo de navegar
    /*@Composable
    fun PersonalInfo(name: String) {
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
                    painter = painterResource(id = R.drawable.perfil),
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
                OutlinedButton(onClick = { *//**//* },
                    border = BorderStroke(1.dp, Color.Blue),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(text = "Ir Activity 2")


                }
            }

        }
    }*/




    /**
     * Nos permite ver la vista interactiva
     */
    @Preview
    @Composable
    fun PreviewPersonalInfo() {

      //  PersonalInfo("Kratos1700")

        // mostramos la pantallaPrimera.kt
        //PantallaPrimera()
        AppNavigation()
    }

}


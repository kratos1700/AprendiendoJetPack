package com.example.aprendiendo.room.app

import android.app.Application
import android.util.Log
import com.example.aprendiendo.room.AppDatabase

/*
ESTA CLASE ES LA QUE SE EJECUTA AL INICAR LA APP
CREAREMOS LA BBD EN ESTA CLASE PARA PODER USAR SUS OPCIONES EN TODA LA APP
En el manifest tenemos que poner la etiqueta:
<application
        android:name=".room.app.App"
 */
class App : Application() {
    companion object{
         lateinit var db:AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = AppDatabase.initDatabase(this)
        Log.d("APP", "ONCREATE..... db inicializada")
    }
}
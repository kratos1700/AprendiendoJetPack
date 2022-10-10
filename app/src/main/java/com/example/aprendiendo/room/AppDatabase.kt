package com.example.aprendiendo.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aprendiendo.room.database.entities.Alumno
import com.example.aprendiendo.room.database.entities.Materia
import com.example.aprendiendo.room.database.entities.Nota

//especificamos las entidades para crear la base de datos con
// el patron singleton
@Database(
    entities = [Alumno::class, Materia::class, Nota::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var db: AppDatabase? = null
        fun initDatabase(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(context, AppDatabase::class.java, "test").build()
                Log.d("ROOM", "BASE DATOS CREADA...")
            }
            Log.d("ROOM", "RETORNANDO LA BBDD CREADA")
            return db!!

        }
    }
}
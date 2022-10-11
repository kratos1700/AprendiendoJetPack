package com.example.aprendiendo.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.aprendiendo.room.database.daos.AlumnoDao
import com.example.aprendiendo.room.database.daos.MateriaDao
import com.example.aprendiendo.room.database.daos.NotaDao
import com.example.aprendiendo.room.database.entities.Alumno
import com.example.aprendiendo.room.database.entities.Materia
import com.example.aprendiendo.room.database.entities.Nota
import com.example.aprendiendo.room.utils.DateConverter

//especificamos las entidades para crear la base de datos con
// el patron singleton
@Database(
    entities = [Alumno::class, Materia::class, Nota::class],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    //funcion abstracta para poder usar el DAO para hacer el CRUD
    abstract fun alumnoDao():AlumnoDao
    abstract fun materiaDao():MateriaDao
    abstract fun notaDao():NotaDao

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
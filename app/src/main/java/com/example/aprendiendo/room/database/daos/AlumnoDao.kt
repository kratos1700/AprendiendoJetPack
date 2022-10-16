package com.example.aprendiendo.room.database.daos

import androidx.room.*
import com.example.aprendiendo.room.database.entities.Alumno
import kotlinx.coroutines.flow.Flow

@Dao
interface AlumnoDao: BaseDao<Alumno> {

    @Query("SELECT * FROM alumnos")
   // fun findAll():List<Alumno>
    fun findAll():Flow<List<Alumno>> // añadimos el Flow de corrutina

    @Query("SELECT * FROM alumnos WHERE id=:id")
    fun findAllById(id:Long):Alumno
}
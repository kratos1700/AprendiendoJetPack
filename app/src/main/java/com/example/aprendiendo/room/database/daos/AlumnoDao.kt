package com.example.aprendiendo.room.database.daos

import androidx.room.*
import com.example.aprendiendo.room.database.entities.Alumno

@Dao
interface AlumnoDao: BaseDao<Alumno> {

    @Query("SELECT * FROM alumnos")
    fun findAll():List<Alumno>

    @Query("SELECT * FROM alumnos WHERE id=:id")
    fun findAllById(id:Long):Alumno
}
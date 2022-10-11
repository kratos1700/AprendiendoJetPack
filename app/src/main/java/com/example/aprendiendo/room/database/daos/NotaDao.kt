package com.example.aprendiendo.room.database.daos

import androidx.room.*
import com.example.aprendiendo.room.database.entities.Nota

@Dao
interface NotaDao:BaseDao<Nota> {
   /* @Insert
    fun create(nota: Nota):Long

    @Update
    fun update(nota: Nota)

    @Delete
    fun delete(nota: Nota)*/

    @Query("SELECT * FROM notas")
    fun findAll():List<Nota>

    @Query("SELECT * FROM notas WHERE alumno_id=:alumno and materia_id=:materia")
    fun findAllById(alumno:Long, materia:Long): Nota
}

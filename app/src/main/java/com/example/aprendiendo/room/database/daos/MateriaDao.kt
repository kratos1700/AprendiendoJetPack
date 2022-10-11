package com.example.aprendiendo.room.database.daos

import androidx.room.*
import com.example.aprendiendo.room.database.entities.Materia

@Dao
interface MateriaDao:BaseDao<Materia> {

    @Query("SELECT * FROM materias")
    fun findAll():List<Materia>

    @Query("SELECT * FROM materias WHERE id=:id")
    fun findAllById(id:Long): Materia
}

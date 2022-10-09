package com.example.aprendiendo.room.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumnos")
data class Alumno(

    val nombre: String,
    val apellido: String,
    val edad: Int

):BaseEntity()

package com.example.aprendiendo.room.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materias")
data class Materia(
    val nombre:String,
    val aula:String,
    val descripcion:String

):BaseEntity()

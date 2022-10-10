package com.example.aprendiendo.room.database.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

// clase abstracta para tener los atributos que se repiten en todas las entities
abstract class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
/*
    @ColumnInfo(name = "create_at")
    var createAt = Date(System.currentTimeMillis())
    @ColumnInfo(name = "update_at")
    var updateAt = Date(System.currentTimeMillis())*/
}
package com.example.aprendiendo.room.database.daos

import androidx.room.*


/*
    INTERFACE GENERICA PARA USAR EL DAO
 */

@Dao
interface BaseDao<T> {

    @Insert
    fun create(t: T):Long

    @Update
    fun update(t: T)

    @Delete
    fun delete(t: T)


}
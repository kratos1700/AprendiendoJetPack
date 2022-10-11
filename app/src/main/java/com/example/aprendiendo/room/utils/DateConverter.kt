package com.example.aprendiendo.room.utils

import androidx.room.TypeConverter
import java.util.*

object DateConverter {
    @TypeConverter
    fun toDate(epoch:Long):Date{
        return Date(epoch)
    }

    @TypeConverter
    fun fromDate(date:Date):Long{
        return date.time
    }
}
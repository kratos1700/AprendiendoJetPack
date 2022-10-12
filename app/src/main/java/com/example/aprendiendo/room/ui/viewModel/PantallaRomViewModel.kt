package com.example.aprendiendo.room.ui.viewModel

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aprendiendo.room.AppDatabase
import com.example.aprendiendo.room.database.entities.Alumno
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PantallaRomViewModel : ViewModel() {


    fun saveAlumnos(alumno: Alumno, context: Context): MutableState<Long?> {
        val mutableState: MutableState<Long?> = mutableStateOf(null)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                // abrimos la DDBB y creamos el alumno
                val id = AppDatabase.initDatabase(context).alumnoDao().create(alumno)
                mutableState.value = id
            }
        }
        return mutableState
    }

    fun saveAlumnosLive(alumno: Alumno, context: Context): LiveData<Long> {
        val liveData = MutableLiveData<Long>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                // abrimos la DDBB y creamos el alumno
                val id = AppDatabase.initDatabase(context).alumnoDao().create(alumno)
                liveData.postValue(id)
            }
        }
        return liveData
    }
}
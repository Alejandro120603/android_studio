package com.example.actividad1am.persistencia

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Preferencias(private val contexto: Context) {
    companion object {
    val Context.dataStore: DataStore<Preferences>
    by preferencesDataStore(name = "Configuraciones")
        val AGE = intPreferencesKey("age")
        val NAME = stringPreferencesKey("name")
        val HASPET = booleanPreferencesKey("hasPet")
    }

    val age: Flow<Int> = contexto.dataStore.data.map {
        //it[AGE] ?: 0
        preferences -> preferences[AGE] ?: 0
    }
    val name: Flow<String> = contexto.dataStore.data.map {
        //it[AGE] ?: 0
            preferences -> preferences[NAME] ?: "Sin nombre asignado"
    }
    val hasPet: Flow<Boolean> = contexto.dataStore.data.map {
        //it[AGE] ?: 0
            preferences -> preferences[HASPET] ?: false
    }

    suspend fun GuardarDatosPersonales (edad: Int, nombre: String, mascota: Boolean) {
        contexto.dataStore.edit { settings ->
            settings[AGE] = 26
            settings[NAME] =  "Juan Perez Perez"
            settings[HASPET] = false }
    }

    suspend fun BorrarConfiguraciones (personName: String, personAge: Int) {
        contexto.dataStore.edit {
            it.remove(AGE)
            it.remove(NAME)
            it.remove(HASPET)
        }
        }

    }

package com.example.aula39exercicioroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aula39exercicioroom.listatodo.dao.ListaDao
import com.example.aula39exercicioroom.listatodo.entity.ListaEntity

@Database(
    entities = [ListaEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {

    abstract fun listaDao(): ListaDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        // SINGLETON
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "listaTodo"
                ).build()
            }
            return INSTANCE!!
        }
    }
}
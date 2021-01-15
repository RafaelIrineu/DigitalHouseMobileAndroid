package com.example.aula39.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aula39.cartao.entity.CartaoEntity
import com.example.aula39.cartao.entity.dao.CartaoDao

@Database(
    entities = [CartaoEntity::class], //se tiver mais entidades colocar virgula
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun cartaoDao(): CartaoDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        // SINGLETON
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pagbem"
                ).build()
            }
            return INSTANCE!!
        }
    }
}
package com.example.aula39exercicioroom.listatodo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tarefa")
data class ListaEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo
    var descricao: String
)
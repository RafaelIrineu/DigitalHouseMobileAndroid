package com.example.aula39exercicioroom.listatodo.dao

import androidx.room.*
import com.example.aula39exercicioroom.listatodo.entity.ListaEntity

@Dao
interface ListaDao {

    @Insert
    suspend fun inserirTarefa(tarefa: ListaEntity): Long

    @Query("SELECT * FROM Tarefa")
    suspend fun obterTarefas(): List<ListaEntity>

    @Transaction
    @Query("UPDATE Tarefa SET descricao = :descricao Where id = :id")
    fun atualizarTarefa(descricao: String, id: Long)

    @Update @Transaction
    fun atualizarTarefa(tarefa: ListaEntity)
}
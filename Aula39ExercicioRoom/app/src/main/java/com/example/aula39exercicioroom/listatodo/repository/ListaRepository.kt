package com.example.aula39exercicioroom.listatodo.repository

import com.example.aula39exercicioroom.listatodo.dao.ListaDao
import com.example.aula39exercicioroom.listatodo.entity.ListaEntity

class ListaRepository(private val listaDao: ListaDao) {
    suspend fun inserirTarefa(tarefa: ListaEntity) = listaDao.inserirTarefa(tarefa)
    suspend fun obterTarefas(): List<ListaEntity> = listaDao.obterTarefas()
    suspend fun atualizarTarefa(descricao: String, id: Long) = listaDao.atualizarTarefa(descricao, id)
}
package com.example.aula39exercicioroom.listatodo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.aula39exercicioroom.listatodo.entity.ListaEntity
import com.example.aula39exercicioroom.listatodo.repository.ListaRepository
import kotlinx.coroutines.Dispatchers

class ListaViewModel(private val repository: ListaRepository) : ViewModel() {

    fun inserirTarefa(descricao: String) = liveData(Dispatchers.IO) {
        val tarefa = ListaEntity(0, descricao)
        val newId = repository.inserirTarefa(ListaEntity(0, descricao))

        tarefa.id = newId

        emit(tarefa)
    }

    fun obterTarefas() = liveData(Dispatchers.IO) {
        emit(repository.obterTarefas())
    }

    fun atualizarTarefa(id: Long, descricao: String) = liveData(Dispatchers.IO) {
        repository.atualizarTarefa(descricao, id)
        emit(true)
    }

    class ListaViewModelFactory(private val repository: ListaRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ListaViewModel(repository) as T
        }
    }
}
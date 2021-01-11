package com.example.aula39exercicioroom.listatodo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aula39exercicioroom.R
import com.example.aula39exercicioroom.listatodo.entity.ListaEntity

class ListaAdapter : RecyclerView.Adapter<ListaViewHolder>() {
    private val _tarefas: MutableList<ListaEntity> = mutableListOf()

    fun adicionarTarefa(tarefa: ListaEntity) {
        _tarefas.add(tarefa)
        notifyDataSetChanged()
    }

    fun adicionarTarefas(tarefas: List<ListaEntity>) {
        _tarefas.addAll(tarefas)
        notifyDataSetChanged()
    }

    fun atualizar(listaEntity: ListaEntity) {
        for (tarefa in _tarefas) {
            if (tarefa.id == listaEntity.id) {
                tarefa.descricao = listaEntity.descricao
                break
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_item, parent, false)
        return ListaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val item = _tarefas[position]
        holder.bind(item)
    }

    override fun getItemCount() = _tarefas.size
}
package com.example.aula39exercicioroom.listatodo.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aula39exercicioroom.R
import com.example.aula39exercicioroom.listatodo.entity.ListaEntity

class ListaViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val descricaoTarefa = view.findViewById<TextView>(R.id.txtItens)
    private val idTarefa = view.findViewById<TextView>(R.id.txtId)

    fun bind (tarefa: ListaEntity){
        descricaoTarefa.text = tarefa.descricao
        idTarefa.text = tarefa.id.toString()
    }
}